package Model.Moves;

import Gameplay.Combat.Controller.CombatContext;

import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;

public class Effect<T> {
    OptionalDouble probability;
    Consumer<T> effect;
    Function<CombatContext, T> target;
//    BattlefieldTarget target;

    public Effect(
            OptionalDouble probability,
            Consumer<T> effect,
            Function<CombatContext, T> target
    ) {
        this.probability = probability;
        this.effect = effect;
    }

    public OptionalDouble getProbability() {
        return probability;
    }

    public void setProbability(OptionalDouble probability) {
        this.probability = probability;
    }

    public Consumer<T> getEffect() {
        return effect;
    }

    public void setEffect(Consumer<T> effect) {
        this.effect = effect;
    }

    public Function<CombatContext, T> getTarget() {
        return target;
    }

    public void setTarget(Function<CombatContext, T> target) {
        this.target = target;
    }
}

