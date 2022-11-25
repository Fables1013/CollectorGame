package Model;

import Model.Creature_Configs.Creature;
import Model.PlayerTypes.Combatant;

import java.util.*;

public class Battlefield {
    HashMap<Combatant, LinkedList<Creature>> battlefield;
    int maxCreaturesPerPlayer;

    public Battlefield(int maxCreaturesPerPlayer) {
        this.maxCreaturesPerPlayer = maxCreaturesPerPlayer;
        this.battlefield = new HashMap<>();
    }

    public void addCreature(Combatant player, Creature creature) {
        LinkedList<Creature> inBattleField = getCreaturesOnBattlefield(player);
        int currentNumberOfCreatures = inBattleField.size();
        if (currentNumberOfCreatures < maxCreaturesPerPlayer) {
            inBattleField.add(creature);
        } else System.out.println("Could not add creature to battlefield, battlefield was full");
    }

    public void updatePlayer(Combatant player, LinkedList<Creature> creatures) {
        int numCreaturesToAdd = creatures.size();
        if (numCreaturesToAdd <= maxCreaturesPerPlayer) {
            battlefield.put(player, creatures);
        } else
            System.out.println("Could not add creature to battlefield, tried to add too many creatures");
    }

    public void removeCreature(Combatant player, Creature creature) {
        LinkedList<Creature> inBattleField = getCreaturesOnBattlefield(player);
        boolean creatureOnField = inBattleField.contains(creature);
        if (creatureOnField) {
            inBattleField.remove(creature);
        } else System.out.println("Could not remove creature from battlefield, creature wasn't there");
    }

    // Returns all creatures controlled by players who are not the current player
    public LinkedList<Creature> getOpposingCreatures(Combatant player) {
        // TODO: make this not suck
        List<Creature> AL = battlefield
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() != player)
                .map(Map.Entry::getValue)
                .toList()
                .stream().flatMap(List::stream).toList();

        return new LinkedList<>(AL);
    }

    public LinkedList<Creature> getCreaturesOnBattlefield(Combatant player) {
        return battlefield.getOrDefault(player, new LinkedList<Creature>());
    }

    @Override
    public String toString() {
        StringBuilder battleFieldSummary = new StringBuilder();
        battleFieldSummary.append("Battlefield: \n");
        for (Combatant p: battlefield.keySet()) {
            String playerName = p.name;
            LinkedList<Creature> activeCreatures = getCreaturesOnBattlefield(p);

            StringBuilder bfSummary = new StringBuilder();
            for (Creature c : activeCreatures) {
                bfSummary.append(c.toCombatString());
            }

            String playerSummary = bfSummary.toString();
            String fullPlayerSummary = playerName + ": " + playerSummary;
            battleFieldSummary.append(fullPlayerSummary).append("\n");
        }

        return battleFieldSummary.toString();
    }
}
