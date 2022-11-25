package Gameplay.Combat.CombatPhases.TurnActions;

import Gameplay.Combat.CombatPhases.TurnActionType;
import Gameplay.Combat.Controller.CombatContext;
import Gameplay.Combat.Controller.TurnActionDetails.TurnActionDetails;
import Model.Creature_Configs.Creature;
import Model.PlayerTypes.Combatant;

abstract public class TurnAction {
    TurnActionType turnAction;
    TurnActionDetails actionDetails;
    abstract void evaluate(CombatContext context);

    public TurnActionType getTurnAction() {
        return turnAction;
    }

    public void setTurnAction(TurnActionType turnAction) {
        this.turnAction = turnAction;
    }

    public TurnActionDetails getActionDetails() {
        return actionDetails;
    }

    public void setActionDetails(TurnActionDetails details) {
        this.actionDetails = details;
    }
}
