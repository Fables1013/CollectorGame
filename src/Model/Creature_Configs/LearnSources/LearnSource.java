package Model.Creature_Configs.LearnSources;

public class LearnSource {
    LearnType learnType;
    int levelRequirement;

    public LearnSource(LearnType learnType, int levelRequirement) {
        this.learnType = learnType;
        this.levelRequirement = levelRequirement;
    }
}

