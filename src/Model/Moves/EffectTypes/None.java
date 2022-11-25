package Model.Moves.EffectTypes;

import Model.Creature_Configs.Creature;
import Model.Moves.EffectType;

public class None extends EffectType {

    @Override
    public void apply(Creature target) {};

    public None() {};
    private static final None instance = new None();

    public static None getInstance() {
        return instance;
    }
}
