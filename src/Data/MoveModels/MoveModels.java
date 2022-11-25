package Data.MoveModels;

import Data.AttributePair;
import Gameplay.Combat.Controller.CombatContext;
import Model.BattlefieldTarget;
import Model.Creature_Configs.CombatCreature;
import Model.Creature_Configs.Creature;
import Model.Creature_Configs.Status;
import Model.Moves.Effect;
import Model.Moves.Move;
import Model.Moves.MoveType;
import Model.Moves.PPConfigs.highPP;
import Model.Moves.PPConfigs.lowPP;
import Model.TypeAttribute;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;

public class MoveModels {
    public static Move tackle = new Move(
            "Tackle",
            OptionalInt.of(40),
            OptionalInt.empty(),
            new Effect[]{
                    new Effect(
                            OptionalDouble.empty(),
                            cc -> {}
                    )},
            highPP.getInstance(),
            MoveType.Attack,
            new AttributePair(TypeAttribute.Normal, TypeAttribute.None)
    );

    public static Move flamethrower = new Move(
            "Flamethrower",
            OptionalInt.of(90),
            OptionalInt.empty(),
            new Effect[]{
                    new Effect<CombatCreature>(
                            OptionalDouble.of(0.10),
                            c -> c.updatePrimaryStatus(Status.BURN),
                            cc -> cc.getCurrentAction().getActionDetails()
                    )},
            lowPP.getInstance(),
            MoveType.SpecialAttack,
            new AttributePair(TypeAttribute.Fire)
    );

    public static Move growl = new Move(
            "Growl",
            OptionalInt.empty(),
            OptionalInt.empty(),
            new Effect[]{
                    new Effect<Creature>(
                            OptionalDouble.of(1.0),
                            c -> c.combatStats.getAttack().changeModifier(-1),
                            BattlefieldTarget.SingleTarget
                    )},
            highPP.getInstance(),
            MoveType.Status,
            new AttributePair(TypeAttribute.Normal)
    );
}
