package Gameplay.Combat.Controller;

import Gameplay.Combat.CombatPhases.TurnActions.Attack;
import Gameplay.Combat.Controller.TurnActionDetails.AttackDetails;
import Gameplay.Combat.Controller.TurnActionDetails.ItemDetails;
import Gameplay.Combat.Controller.TurnActionDetails.TurnActionDetails;
import Model.Creature_Configs.Creature;
import Model.PlayerTypes.Combatant;

public class CombatExecutor {
    CombatContext context;

    public CombatExecutor(CombatContext context) {
        this.context = context;
    }

    public void executeTurnAction(TurnActionDetails turnAction) {
        if (turnAction instanceof AttackDetails a) handleAttack(a);
        //else if (turnAction instanceof ItemDetails<?> i) {}; /*handleItem(i)*/;
        else {}
    }

    public void handleAttack(AttackDetails a) {
        Attack attack = new Attack(a);
        attack.evaluate(context);
    }

    public void handleItem(ItemDetails i) {

    }

}
