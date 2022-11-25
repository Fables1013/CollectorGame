package Model.Creature_Configs.Stats;

import Model.Creature_Configs.Health;
import Model.Creature_Configs.Status;
import Model.Moves.MoveType;

public class CombatStats {
    CombatStat attack;
    CombatStat defense;
    CombatStat specialAttack;
    CombatStat specialDefense;
    CombatStat speed;
    Health health;

    public CombatStats(OverworldStats overworldStats) {
        this.health = overworldStats.getHealth();
        this.attack = new CombatStat(overworldStats.attack, 0);
        this.defense = new CombatStat(overworldStats.defense, 0);
        this.specialAttack = new CombatStat(overworldStats.specialAttack, 0);
        this.specialDefense = new CombatStat(overworldStats.specialDefense, 0);
        this.speed = new CombatStat(overworldStats.speed, 0);
    }

    public int getStatForAttackType(MoveType moveType) {
        return switch (moveType) {
            case Attack -> this.getAttackStat();
            case SpecialAttack -> this.getSpecialAttackStat();
            case Status -> 0;
        };
    }

    public int getStatForDefenseType(MoveType moveType) {
        return switch (moveType) {
            case Attack -> this.getDefenseStat();
            case SpecialAttack -> this.getSpecialDefenseStat();
            case Status -> 0;
        };
    }

    public void modifyCombatStatsForStatus(Status status) {
        clearStatusImpact();
        switch (status) {
            case BURN -> attack.setStatus(true);
            case PARALYZED -> speed.setStatus(true);
        }
    }

    public void clearStatusImpact() {
        attack.setStatus(false);
        defense.setStatus(false);
        specialAttack.setStatus(false);
        specialDefense.setStatus(false);
        speed.setStatus(false);
    }

    public CombatStat getAttack() {
        return attack;
    }

    public CombatStat getDefense() {
        return defense;
    }

    public CombatStat getSpecialAttack() {
        return specialAttack;
    }

    public CombatStat getSpecialDefense() {
        return specialDefense;
    }

    public CombatStat getSpeed() {
        return speed;
    }

    public int getAttackStat() {
        return this.attack.finalStat;
    }

    public int getSpecialAttackStat() {
        return this.specialAttack.finalStat;
    }

    public int getDefenseStat() {
        return this.defense.finalStat;
    }

    public int getSpecialDefenseStat() {
        return this.specialDefense.finalStat;
    }

    public int getSpeedStat() {
        return this.speed.finalStat;
    }

    public int getCurrentHealth() {
        return this.health.getCurrentHealth();
    }

    public Health getHealth() { return this.health; }
}
