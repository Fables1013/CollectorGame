package Gameplay.Combat.AI;

import Gameplay.Combat.Controller.TurnActionDetails.AttackDetails;
import Gameplay.Combat.CombatPhases.TurnActionType;
import Gameplay.Combat.Controller.CombatContext;
import Model.Creature_Configs.Creature;
import Model.Moves.Move;
import Model.PlayerTypes.Combatant;

import java.util.LinkedList;
import java.util.Random;

public class AiTurnAction {

    double superEffectiveMoveChance = 0.4;
    public AiTurnAction() {  }
    public TurnActionType getTurnAction(CombatContext context, Combatant aiPlayer) {
        return TurnActionType.Attack;
    }

    public AttackDetails selectAttack(CombatContext context, Combatant aiPlayer, Creature turnCreature) {
        LinkedList<Creature> oppositionCreatures = context.getBattlefield().getOpposingCreatures(aiPlayer);
        Creature oppositionTarget = targetWithTypeAdvantage(turnCreature, oppositionCreatures);

        Move move;
        if (oppositionTarget == null) {
            move = turnCreature.moveset.getRandomMove();
        } else {
            boolean useSE = shouldUseSuperEffectiveMove(superEffectiveMoveChance);
            if (useSE)
                move = turnCreature.getSuperEffectiveMove(oppositionTarget);
            else
                move = turnCreature.moveset.getRandomMove();
        }

        return new AttackDetails(turnCreature, oppositionTarget, move);
    }

    public Creature targetWithTypeAdvantage(Creature turnCreature, LinkedList<Creature> opposition) {
        for (Creature creature : opposition) {
            Move superEffectiveMove = turnCreature.getSuperEffectiveMove(creature);
            if (superEffectiveMove != null) {
                return creature;
            }
        }
        return null;
    }

    public boolean shouldUseSuperEffectiveMove(double prob) {
        Random rand = new Random();
        int num = rand.nextInt(100);
        return num < prob * 100;
    }

}
