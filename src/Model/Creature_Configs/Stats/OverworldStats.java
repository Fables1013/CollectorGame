package Model.Creature_Configs.Stats;

import Model.Creature_Configs.Health;
import Model.Moves.MoveType;

public class OverworldStats {
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;
    Health health;

    public OverworldStats(Health health, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public OverworldStats(BaseStats baseStats, int level) {
        this.health = new Health(
                (int) hpCombatStatFromBase(baseStats.hp(), level),
                (int) hpCombatStatFromBase(baseStats.hp(), level)
        );
        this.attack = (int) combatStatFromBase(baseStats.attack(), level);
        this.defense = (int) combatStatFromBase(baseStats.defense(), level);
        this.specialAttack = (int) combatStatFromBase(baseStats.specialAttack(), level);
        this.specialDefense = (int) combatStatFromBase(baseStats.specialDefense(), level);
        this.speed = (int) combatStatFromBase(baseStats.speed(), level);
    }

    private double hpCombatStatFromBase(double baseStat, int level) {
        return 2 * baseStat * level / 100 + level + 10;
    }

    private double combatStatFromBase(double baseStat, int level) {
        return 2 * baseStat * level / 100 + 5;
    }

    public int getStatForAttackType(MoveType moveType) {
        return switch (moveType) {
            case Attack -> this.getAttack();
            case SpecialAttack -> this.getSpecialAttack();
            case Status -> 0;
        };
    }

    public int getStatForDefenseType(MoveType moveType) {
        return switch (moveType) {
            case Attack -> this.getDefense();
            case SpecialAttack -> this.getSpecialDefense();
            case Status -> 0;
        };
    }

    public int getAttack() {
        return this.attack;
    }

    public int getSpecialAttack() {
        return this.specialAttack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpecialDefense() {
        return this.specialDefense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Health getHealth() {
        return this.health;
    }
}
