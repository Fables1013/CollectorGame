package Gameplay.Combat.Controller.TurnActionDetails;

import Model.Creature_Configs.Creature;
import Model.Moves.Move;

public class AttackDetails extends TurnActionDetails {
    Creature turnCreature;
    Creature target;
    Move move;

    public AttackDetails(Creature attacker, Creature target, Move move) {
        this.turnCreature = attacker;
        this.target = target;
        this.move = move;
    }

    public String combatDescription() {
        return turnCreature.nickname + " attacks " +  target.nickname + " with " +  move.name + ".";
    }

    public Creature getTurnCreature() { return turnCreature; }
    public Move getMove() { return move; }
    public Creature getTarget() { return target; }
}
