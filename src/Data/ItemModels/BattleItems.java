package Data.ItemModels;

import Model.Creature_Configs.Creature;
import Model.Items.BattleItem;
import Model.Moves.Move;

public class BattleItems {

    public BattleItem<Creature> potion = new BattleItem<>(
            "Potion",
            true,
            c -> c.heal(20)
    );

    public BattleItem<Creature> superPotion = new BattleItem<>(
            "Super Potion",
            true,
            c -> c.heal(50)
    );

    public BattleItem<Creature> hyperPotion = new BattleItem<>(
            "Hyper Potion",
            true,
            c -> c.heal(200)
    );

    public BattleItem<Move> elixir = new BattleItem<>(
            "Elixir",
            true,
            m -> m.getPP().resetPP()
    );

    public BattleItems() {}
    public static BattleItems getInstance() {return instance;}
    private static BattleItems instance = new BattleItems();

}
