package Model.Creature_Configs;

import Data.AttributePair;
import Model.Creature_Configs.Metadata.Gender;
import Model.Creature_Configs.Stats.CombatStats;
import Model.Creature_Configs.Stats.OverworldStats;
import Model.Moves.Move;
import Model.Moves.MoveType;

public class Creature {
    public CreatureModel creatureModel;
    public String nickname;
    public Gender gender;
    public Moveset moveset;
    Status status;
    public int level;
//    public Health health;
    public boolean isActive;
    public OverworldStats overworldStats;
    public CombatStats combatStats;


    public Creature(
            CreatureModel model,
            String nickname,
            Gender gender,
            Moveset moveset,
            Status status,
//            Health health,
            int level
    ) {
        this.creatureModel = model;
        this.nickname = nickname;
        this.gender = gender;
        this.moveset = moveset;
        this.status = status;
//        this.health = health;
        this.level = level;
        updateOverworldStats();
        this.combatStats = new CombatStats(overworldStats);
        this.isActive = combatStats.getHealth().currentHealth > 0;
    }
    public boolean hasStatus() {
        return status == Status.NONE;
    }
    public void updateCurrentHealth(int newHealth) {combatStats.getHealth().setCurrentHealth(newHealth);}
    public Move getSuperEffectiveMove(Creature targetCreature) {
        boolean hasSuperEffective = false;
        AttributePair targetType = targetCreature.getType();
        for (Move move: moveset.getMoves()) {
            if (move.getMoveType() == MoveType.Attack && move.getAttackMultiplier(targetType) > 0) {
                return move;
            }
        }
        return null;
    }

    public String toCombatString() {
        return String.format(
                "%s (%s) %.0f%% health remaining.",
                nickname,
                creatureModel.speciesName,
                combatStats.getHealth().healthPercent() * 100
        );
    }
    public void updateOverworldStats() {
        this.overworldStats = new OverworldStats(creatureModel.baseStats, level);
    }

    // Getters & Setters
    public AttributePair getType() { return creatureModel.attributePair; }

    public CombatStats getCombatStats() { return combatStats; }

    public int getLevel() { return level; }
    public void takeDamage(int damage) {
        combatStats.getHealth().takeDamage(damage);
        this.isActive = combatStats.getCurrentHealth() != 0;
    }
    public void heal(int healAmt) {  combatStats.getHealth().healDamage(healAmt); }

    public void updatePrimaryStatus(Status status) {
        if (this.status == Status.NONE) {
            this.status = status;
        }
        modifyCombatStatsForStatus(status);
    }

    private void modifyCombatStatsForStatus(Status status) {
        combatStats.modifyCombatStatsForStatus(status);
    }
}
