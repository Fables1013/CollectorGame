package Model.Items;

import java.util.function.Consumer;
import java.util.function.Function;

public class BattleItem<T> extends Item {
    Consumer<T> effect;

    public BattleItem(String name, boolean singleUse, Consumer<T> effect) {
        this.name = name;
        this.singleUse = singleUse;
        this.effect = effect;
    }

    public void apply(T arg) { effect.accept(arg); }
}
