package Gameplay.Combat.Controller.TurnActionDetails;

import Gameplay.Combat.CombatPhases.TurnActionType;
import Model.Creature_Configs.Creature;

public class SwitchCreatureDetails extends TurnActionDetails {
    Creature currentCreature;
    Creature targetCreature;

    public SwitchCreatureDetails(Creature currentCreature, Creature targetCreature) {
        this.turnActionType = TurnActionType.Switch;
        this.currentCreature = currentCreature;
        this.targetCreature = targetCreature;
    }
}
