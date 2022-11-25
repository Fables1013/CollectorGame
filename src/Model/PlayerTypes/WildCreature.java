package Model.PlayerTypes;

import Gameplay.Combat.Controller.PlayerType;
import Model.Team;

public class WildCreature extends Combatant {

    public WildCreature(Team team) {
        super(team, "Wild");
        this.type = PlayerType.AI;
    }
}
