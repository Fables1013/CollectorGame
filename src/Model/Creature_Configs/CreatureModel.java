package Model.Creature_Configs;

import Data.AttributePair;
import Model.Creature_Configs.Stats.BaseStats;

public class CreatureModel {
    public String speciesName;
    public int id;
    public Learnset learnset;
    public AttributePair attributePair;
    public BaseStats baseStats;

    public CreatureModel(String speciesName, int id, Learnset learnset, AttributePair attributePair, BaseStats baseStats) {
        this.speciesName = speciesName;
        this.id = id;
        this.learnset = learnset;
        this.attributePair = attributePair;
        this.baseStats = baseStats;
    }
}
