package Gameplay.Combat.Configs.DefaultConfigs;

import Gameplay.Combat.Configs.VictoryConditionConfigs.VictoryConditionConfigs;
import Gameplay.Combat.Controller.CombatContext;
import Model.PlayerTypes.Combatant;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class VictoryConditionConfigDefault implements VictoryConditionConfigs {

    public VictoryConditionConfigDefault() {}

    @Override
    public Combatant checkCombatVictor(CombatContext context) {
        Combatant[] combatants = context.getPlayers();
        Function<Combatant, Boolean> lossCondition = cp -> cp.team.numberActiveCreatures() == 0;

        Stream<Combatant> playerStream = Arrays.stream(combatants).filter(p -> !lossCondition.apply(p));
        Combatant[] activePlayers = playerStream.toArray(Combatant[]::new);

        return activePlayers.length == 1 ? activePlayers[0] : null;

    }
}
