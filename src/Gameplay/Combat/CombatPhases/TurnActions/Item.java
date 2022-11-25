package Gameplay.Combat.CombatPhases.TurnActions;

import Gameplay.Combat.Controller.CombatContext;
import Gameplay.Combat.Controller.TurnActionDetails.ItemDetails;

public class Item extends TurnAction {

    public Item(ItemDetails details) {
        this.details = details;
    }

    @Override
    void evaluate(CombatContext context) {

    }
}
