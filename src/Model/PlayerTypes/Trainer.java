package Model.PlayerTypes;

import Model.Items.Item;
import Model.Team;

import java.util.UUID;

public class Trainer extends Combatant {

    public Item[] items;
    double money;
    public UUID id;

    public Trainer(Team team, Item[] items, String name, double money, UUID id) {
        super(team, name);
        this.items = items;
        this.money = money;
        this.id = id;
    }
}


