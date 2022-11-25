package Model.PlayerTypes;

import Gameplay.Combat.Controller.PlayerType;
import Model.Encyclopedia;
import Model.Items.Item;
import Model.Team;

import java.util.UUID;

public class Player {
    public Team team;
    public UUID id;
    public PlayerType type;
    public String name;
    public Encyclopedia pokedex;
    public Item[] items;
    double money;


    public Player(Team team, UUID id, PlayerType type, String name, Encyclopedia pokedex, Item[] items, double money) {
        this.team = team;
        this.id = id;
        this.type = type;
        this.name = name;
        this.pokedex = pokedex;
        this.items = items;
        this.money = money;
    }

    public HumanTrainer toCombatant() {
        return new HumanTrainer(this.team, this.items, this.name, this.money, this.id);
    }
}
