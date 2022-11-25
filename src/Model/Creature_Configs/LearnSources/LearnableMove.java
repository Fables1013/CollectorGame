package Model.Creature_Configs.LearnSources;

import Model.Moves.Move;

public class LearnableMove {
    Move move;
    LearnSource learnSource;

    public LearnableMove(Move move, LearnSource learnSource) {
        this.move = move;
        this.learnSource = learnSource;
    }
}
