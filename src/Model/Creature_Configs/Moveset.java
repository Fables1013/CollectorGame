package Model.Creature_Configs;

import Model.Moves.Move;

import java.util.Random;

public class Moveset {
    int maxMoves;
    int minMoves;
    Move[] moves;

    public Moveset(Move[] moves) {
        this.maxMoves = 1;
        this.minMoves = 1;
        this.moves = moves;
    }

    public Move[] getMoves() { return moves; }

    public Move getRandomMove() {
        Random rand = new Random();
        int index = rand.nextInt(moves.length);
        return moves[index];
    }

    @Override
    public String toString() {
        StringBuilder chooseActionPrompt = new StringBuilder();
        for (int i = 0; i < moves.length; i++) {
            String moveName = moves[i].name;
            chooseActionPrompt.append(String.format("%s. %s", i + 1, moveName));
            chooseActionPrompt.append("\n");
        }
        return chooseActionPrompt.toString();
    }
}
