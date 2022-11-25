package Data.CreatureModels;

import Data.AttributePair;
import Data.LearnsetModels.LearnsetConfigs;
import Model.Creature_Configs.Stats.BaseStats;
import Model.Creature_Configs.CreatureModel;
import Model.TypeAttribute;

public class CreatureModelConfigs {
    public static CreatureModel LunaTuna = new CreatureModel(
            "Luna Tuna",
            1,
            LearnsetConfigs.LunaTuna,
            new AttributePair(TypeAttribute.Fire, TypeAttribute.Normal),
            new BaseStats(40, 35, 25, 15, 35, 50)
    );
}
