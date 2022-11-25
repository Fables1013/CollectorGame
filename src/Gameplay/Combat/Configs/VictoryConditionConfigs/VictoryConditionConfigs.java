package Gameplay.Combat.Configs.VictoryConditionConfigs;

import Gameplay.Combat.Controller.CombatContext;
import Model.PlayerTypes.Combatant;

public interface VictoryConditionConfigs {
    Combatant checkCombatVictor(CombatContext context);

}
