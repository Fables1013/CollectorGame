package Model.PlayerTypes;

import Gameplay.Combat.Controller.PlayerType;
import Model.Team;

import java.util.UUID;

public class Combatant {
    public Team team;
    public UUID id;
    public PlayerType type;
    public String name;

    public Combatant(Team team, String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.team = team;
    }

    public String getName() { return this.name; }
}
