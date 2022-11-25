package Data.LearnsetModels;

import Data.MoveModels.MoveModels;
import Model.Creature_Configs.LearnSources.LearnSource;
import Model.Creature_Configs.LearnSources.LearnType;
import Model.Creature_Configs.LearnSources.LearnableMove;
import Model.Creature_Configs.Learnset;

public class LearnsetConfigs {
    public static Learnset LunaTuna = new Learnset(
            new LearnableMove[]{
                    new LearnableMove(
                            MoveModels.tackle,
                            new LearnSource(
                                    LearnType.Level,
                                    1
                            )
                    )
            });
}
