package Model.Creature_Configs;

import Model.Creature_Configs.Stats.CombatStats;

public class CombatCreature extends Creature {
    CombatStats combatStats;
    public CombatCreature(Creature baseCreature) {
        super(
                baseCreature.creatureModel,
                baseCreature.nickname,
                baseCreature.gender,
                baseCreature.moveset,
                baseCreature.status,
//                baseCreature.health,
                baseCreature.level
        );
        this.combatStats = new CombatStats(baseCreature.overworldStats);
    }
}
