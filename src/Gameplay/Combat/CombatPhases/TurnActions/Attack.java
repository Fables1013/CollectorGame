package Gameplay.Combat.CombatPhases.TurnActions;

import Gameplay.Combat.Controller.TurnActionDetails.AttackDetails;
import Gameplay.Combat.CombatPhases.TurnActionType;
import Gameplay.Combat.Controller.CombatContext;
import Model.BattlefieldTarget;
import Model.Creature_Configs.Creature;
import Model.Moves.Effect;
import Model.Moves.Move;
import Model.Moves.MoveType;

import java.util.Random;

public class Attack extends TurnAction {

    TurnActionType turnActionType = TurnActionType.Attack;
    AttackDetails attackDetails;

    public Attack(AttackDetails attackDetails) {
        this.details = attackDetails;
        this.attackDetails = attackDetails;
    }

    @Override
    public void evaluate(CombatContext context) {
        System.out.println(attackDetails.combatDescription());

        MoveType moveType = attackDetails.getMove().getMoveType();
        switch (moveType) {
            case Status -> executeEffect(context);
            case Attack, SpecialAttack -> {
                if (canAttack()) executeAttack(context);
            }
        }
    }

    public boolean canAttack() {
        return attackDetails.getTurnCreature().isActive && attackDetails.getTarget().isActive;
    }

    public void executeAttack(CombatContext context) {
        int damage = calculateCombatDamage(attackDetails);
        Creature target = attackDetails.getTarget();
        target.takeDamage(damage);

        executeEffect(context);
    }

    public void executeEffect(CombatContext context) {
        // TODO: figure out how to improve the Effect domain
        Move move = attackDetails.getMove();
        Effect[] effects = move.getEffects();
        for (Effect e: effects) {
            BattlefieldTarget effTarget = e.getTarget();
            switch (effTarget) {
                case Self -> e.getEffect().accept(attackDetails.getTurnCreature());
                case SingleTarget -> e.getEffect().accept(attackDetails.getTarget());
            }
        }
    }

    int calculateCombatDamage(AttackDetails attackDetails) {
        Creature target = attackDetails.getTarget();
        Creature attacker = attackDetails.getTurnCreature();
        Move move = attackDetails.getMove();

        MoveType moveType = move.getMoveType();
        int attackStat = attacker.getCombatStats().getStatForAttackType(moveType);
        int defenseStat = target.getCombatStats().getStatForDefenseType(moveType);

        int rawDamage;
        if (move.getFixedDamage().isPresent())
            rawDamage = move.getFixedDamage().getAsInt();
        else {
            boolean isCritical = isCritical();
            double stabMultiplier = move.getStabMultiplier(attacker.getType());
            double attackMultiplier = move.getAttackMultiplier(target.getType());
            rawDamage = calculateDamage(
                    attacker.getLevel(),
                    isCritical,
                    move.getPower(),
                    attackStat,
                    defenseStat,
                    stabMultiplier,
                    attackMultiplier);
        }

        return Math.min(Math.max(1, rawDamage), target.combatStats.getCurrentHealth());
    }

    int calculateDamage(int attackerLevel, boolean isCritical, int attackPower, int attackStat, int defenseStat,
                        double stabMultiplier, double attackMultiplier) {
        Random random = new Random();
        double randomFactor = (random.nextDouble(38) + 217.0) / 255.0;

        double criticalMultiplier;

        if (isCritical)
            criticalMultiplier = 2.0;
        else
            criticalMultiplier = 1.0;

        double typeMultipliers = attackMultiplier * stabMultiplier;
        double statMultiplier = attackPower * (double) attackStat / (double) defenseStat / 50.0;
        double baseDamage = ((2.0 * attackerLevel * criticalMultiplier / 5.0) + 2.0);
        double totalDamage = baseDamage * statMultiplier * typeMultipliers * randomFactor;
        return (int) totalDamage;
    }

    private boolean isCritical() {
        return isCritical(0.15);
    }

    private boolean isCritical(double criticalChance) {
        Random random = new Random();
        int roll = random.nextInt(100);
        return roll < criticalChance * 100;
    }
}
