package Gameplay.Combat.Controller.TurnActionDetails;

import Gameplay.Combat.CombatPhases.TurnActionType;
import Model.Items.Item;

public class ItemDetails<T> extends TurnActionDetails {
    T target;
    Item item;

    public ItemDetails(Item item, T target) {
        this.item = item;
        this.target = target;
        this.turnActionType = TurnActionType.Item;
    }
}
