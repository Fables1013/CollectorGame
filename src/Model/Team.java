package Model;

import Model.Creature_Configs.Creature;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Function;

public class Team {
    LinkedList<Creature> team;

    public Team(Creature[] team) {
        this.team = new LinkedList<Creature>(Arrays.asList(team));
    }

    public Boolean validateTeam(Function<Creature[], Boolean> validator) {
        Creature[] teamArray = (Creature[]) team.toArray();
        return validator.apply(teamArray);
    }
    public Creature getFirstCreature() {
        boolean hasCreature = team.size() > 0;
        if (!hasCreature)
//            System.out.println("Could not load creature, none in list");
            System.err.println("Could not load creature, none in list");
        else {
            return team.getFirst();
        }
        return null;
    }

    public void switchCreatureOrder(int firstIndex, int secondIndex) {
        Collections.swap(team, firstIndex, secondIndex);
    }

    public LinkedList<Creature> getFirstActiveCreatures(int numCreatures) {
        LinkedList<Creature> matches = new LinkedList<>();
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).isActive) {
                Creature activeCreature = team.get(i);
                switchCreatureOrder(0, i);
                matches.add(activeCreature);
                if (matches.size() == numCreatures) return matches;
            }
        }
        return matches;
    }

    public int numberActiveCreatures() {
        return team.stream().filter(c -> c.isActive).toArray().length;
    }
}
