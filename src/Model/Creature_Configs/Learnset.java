package Model.Creature_Configs;

import Model.Creature_Configs.LearnSources.LearnableMove;

public class Learnset {
    // Seq of Moves
    LearnableMove[] learnset;

    public Learnset(LearnableMove[] learnset){
        this.learnset = learnset;
    }
}

