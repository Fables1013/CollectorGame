package Tests;

import Data.AttributePair;
import Model.BattlefieldTarget;
import Model.Creature_Configs.Creature;
import Model.Moves.Effect;
import Model.Moves.Move;
import Model.Moves.MoveType;
import Model.Moves.PPConfigs.highPP;
import Model.TypeAttribute;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class MoveTest {
    @Test
    public void canConstructTest() {
        Move move = new Move(
                "Test",
                OptionalInt.of(20),
                OptionalInt.empty(),
                new Effect[] {
                        new Effect<Creature>(
                                OptionalDouble.of(0.30),
                                c -> c.takeDamage(50),
                                BattlefieldTarget.SingleTarget
                        )
                },
                highPP.getInstance(),
                MoveType.Attack,
                new AttributePair(TypeAttribute.Fire)
                );
    }
}
