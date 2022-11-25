package Gameplay.Combat.Controller;

import Gameplay.Combat.AI.AiTurnAction;
import Gameplay.Combat.CombatPhases.TurnActionType;
import Gameplay.Combat.Configs.CombatConfigs.CombatConfigs;
import Gameplay.Combat.Configs.LoadTeamConfigs.LoadTeamConfigs;
import Gameplay.Combat.Configs.LoadTeamConfigs.TeamSource;
import Gameplay.Combat.Configs.VictoryConditionConfigs.VictoryConditionConfigs;
import Gameplay.Combat.Controller.TurnActionDetails.AttackDetails;
import Gameplay.Combat.Controller.TurnActionDetails.TurnActionDetails;
import Model.Battlefield;
import Model.Creature_Configs.Creature;
import Model.Moves.Move;
import Model.PlayerTypes.Combatant;
import Model.Team;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

public class CombatController {

    CombatContext context;
    CombatConfigs configs;
    Battlefield battlefield;
    boolean combatOver;
    AiTurnAction aiLogic;
    CombatExecutor executor;

    public CombatController(Combatant[] combatants) {
        setCombatDefaults(combatants);
        System.out.println("Setting up battlefield...");
        reloadBattlefield();
        displayBattlefieldDetails();
    }
    private void setCombatDefaults(Combatant[] combatants) {
        setupCombat(combatants);
        this.combatOver = false;
        this.configs = new CombatConfigs();
        this.aiLogic = new AiTurnAction();
        this.executor = new CombatExecutor(context);
    }
    public void runBattle() {
        Combatant victor = checkForVictor();
        updateCombatStatus(victor);
        while (!combatOver) {
            ArrayList<TurnActionDetails> playerActions = loadUserActions();
            for (TurnActionDetails tad: playerActions) executor.executeTurnAction(tad);
            displayBattlefieldDetails();

            victor = checkForVictor();
            updateCombatStatus(victor);
        }

        System.out.println(victor.name + " won the battle!");
    }

    public Combatant loadCombatant(Combatant player, LoadTeamConfigs configs) {
        TeamSource source = configs.getTeamSource();
        Team combatTeam = switch (source) {
            case PARTY -> player.team;
            case RANDOM -> player.team;
            case SELECTION -> player.team;
        };
        return new Combatant(combatTeam, player.name);
    }

    public void setupCombat(Combatant[] combatants) {
        this.context = new CombatContext(combatants, null);
    }

    public void reloadBattlefield() {
        int maxNumberCreatures = 1; // TODO: Load this from config file
        Battlefield newBattlefield = new Battlefield(maxNumberCreatures);
        Combatant[] players = context.getPlayers();

        for (int i = 0; i < players.length; i++) {
            Combatant player = (Combatant) Array.get(players, i);
            newBattlefield.updatePlayer(
                    player,
                    player.team.getFirstActiveCreatures(maxNumberCreatures)
            );
        }
        this.battlefield = newBattlefield;
        context.setBattlefield(newBattlefield);
    }

    public String promptUserInput(String msg, Function<String, Boolean> validator) {
        System.out.println(msg);
        return requestUserInput(validator);
    }

    public boolean validateUserInput(String input, Function<String, Boolean> validator) {
        return validator.apply(input);
    }

    public String requestUserInput(Function<String, Boolean> validator) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        if (validateUserInput(s, validator))
            return s;
        else {
            promptUserInput("Previous input was invalid, try again", validator);
            return requestUserInput(validator);
        }
    }

    public Combatant checkForVictor() {
        VictoryConditionConfigs victoryConfigs = configs.victoryConditionConfigs;
        return victoryConfigs.checkCombatVictor(context);
    }

    public void updateCombatStatus(Combatant victor) {
        combatOver = victor != null;
    }

    public ArrayList<TurnActionDetails> loadUserActions() {
        Combatant[] players = context.getPlayers();
        ArrayList<TurnActionDetails> turnActions = new ArrayList<>();

        for (Combatant p : players) {
            PlayerType type = p.type;
            LinkedList<Creature> creatures = context.getActiveCreaturesForPlayer(p);
            for (Creature c : creatures) {
                TurnActionType actionType = switch (type) {
                    case Local -> convertUserInputToTurnActionType(promptUserTurnAction());
                    case AI -> aiLogic.getTurnAction(context, p);
                    case SmartAI -> aiLogic.getTurnAction(context, p);
                    case Remote -> waitForRemoteSelection();
                };

                TurnActionDetails action = switch (actionType) {
                    case Attack -> getAttackAction(p, c);
                    case Item -> getAttackAction(p, c);
                    case Switch -> null;
                    case Run -> null;
                    case Details -> null;
                    case Pass -> null;
                };
                turnActions.add(action);
            }
        }
        return sortTurnActions(turnActions);
    }

    public ArrayList<TurnActionDetails> sortTurnActions(ArrayList<TurnActionDetails> unsorted) {
        // TODO: implement this by implementing Comparable somehow
        LinkedList<TurnActionType> actionOrder = new LinkedList<>();
        actionOrder.add(TurnActionType.Run);
        actionOrder.add(TurnActionType.Pass);
        actionOrder.add(TurnActionType.Item);
        actionOrder.add(TurnActionType.Switch);
        actionOrder.add(TurnActionType.Details);
        actionOrder.add(TurnActionType.Attack);

        /*
        Sort by the order defined above. if there is a conflict of any type other than
        Attack then choose a random order. If there is a conflict on Attack actions then
        decide order based on the speed of the attacking Creature
        */
        Comparator<TurnActionDetails> comparator = new Comparator<TurnActionDetails>() {
            @Override
            public int compare(TurnActionDetails o1, TurnActionDetails o2) {
                TurnActionType o1Type = o1.turnActionType;
                TurnActionType o2Type = o2.turnActionType;
                int result = actionOrder.indexOf(o1Type) - actionOrder.indexOf(o2Type);
                if (result == 0 && o1 instanceof AttackDetails ad1 && o2 instanceof AttackDetails ad2 ) {
                    result = ad2.getTurnCreature().getCombatStats().getSpeedStat() - ad1.getTurnCreature().getCombatStats().getSpeedStat();
                }
                return result;
            }
        };
        unsorted.sort(comparator);
        return unsorted;
    }

    public TurnActionType waitForRemoteSelection() {
        return TurnActionType.Attack;
    }
    // Manage combat functions

    public TurnActionDetails getAttackAction(Combatant player, Creature creature) {
        return switch (player.type) {
            case Local -> getAttackDetails(player, creature);
            case AI -> aiLogic.selectAttack(context, player, creature);
            case SmartAI -> aiLogic.selectAttack(context, player, creature);
            case Remote -> aiLogic.selectAttack(context, player, creature);
        };
    }

    public TurnActionType convertUserInputToTurnActionType(String userInput) {
        return switch (userInput) {
            case "1" -> TurnActionType.Attack;
            case "2" -> TurnActionType.Item;
            case "3" -> TurnActionType.Attack;
            case "4" -> TurnActionType.Attack;
            case "5" -> TurnActionType.Attack;
            case "6" -> TurnActionType.Attack;
            default -> TurnActionType.Attack;
        };
    }

    public String promptUserTurnAction() {
        String chooseActionPrompt = """
                Choose an action.
                1. Attack
                2. Item
                3. Swap Creature
                4. Run
                5. Check Battlefield
                6. Pass
                """;
        String[] validActions = new String[]{"1", "2", "3", "4", "5", "6"};
        Set<String> validActionsSet = new HashSet<>(Arrays.asList(validActions));
        Function<String, Boolean> chooseActionValidator = validActionsSet::contains;
        return promptUserInput(chooseActionPrompt, chooseActionValidator);
    }

    public AttackDetails getAttackDetails(Combatant player, Creature creature) {
        Move attackSelection = promptUserAttackSelection(creature);
        Creature attackTarget = promptUserAttackTarget(player);

        return attackActionFromUserInputs(creature, attackTarget, attackSelection);
    }

    public AttackDetails attackActionFromUserInputs(Creature attacker, Creature defender, Move move) {
        return new AttackDetails(attacker, defender, move);
    }

    public Move promptUserAttackSelection(Creature creature) {
        Move[] moves = creature.moveset.getMoves();
        StringBuilder chooseActionPrompt = new StringBuilder();

        chooseActionPrompt.append(creature.nickname).append(" is attacking! ");
        chooseActionPrompt.append("Select an Attack: \n");
        chooseActionPrompt.append(creature.moveset.toString());

        String[] validActions = new String[]{"1", "2", "3", "4"};
        Set<String> validActionsSet = new HashSet<>(Arrays.asList(validActions));
        Function<String, Boolean> chooseActionValidator = validActionsSet::contains;
        String attackIndex = promptUserInput(chooseActionPrompt.toString(), chooseActionValidator);
        return moves[Integer.parseInt(attackIndex) - 1];
    }

    public Creature promptUserAttackTarget(Combatant player) {
        LinkedList<Creature> possibleTargets = battlefield.getOpposingCreatures(player);
        StringBuilder chooseTargetPrompt = new StringBuilder();
        chooseTargetPrompt.append("Choose Attack target: \n");

        for (int i = 0; i < possibleTargets.size(); i++) {
            Creature target = possibleTargets.get(i);
            String name = target.toCombatString();
            chooseTargetPrompt.append(String.format("%s. %s", i, name));
        }

        String[] validActions = new String[possibleTargets.size()];
        Arrays.setAll(validActions, String::valueOf);

        Set<String> validActionsSet = new HashSet<>(Arrays.asList(validActions));
        Function<String, Boolean> chooseActionValidator = validActionsSet::contains;
        String attackIndex = promptUserInput(chooseTargetPrompt.toString(), chooseActionValidator);
        return possibleTargets.get(Integer.parseInt(attackIndex));
    }

    public void displayBattlefieldDetails() {
        System.out.println(battlefield.toString());
    }
}
