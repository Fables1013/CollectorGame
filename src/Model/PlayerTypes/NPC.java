package Model.PlayerTypes;

import Gameplay.Combat.Controller.PlayerType;
import Model.Items.Item;
import Model.Team;

import java.util.UUID;

public class NPC extends Trainer {
    public NPC(Team team, Item[] items, String name, double money, UUID id) {
        super(team, items, name, money, id);
        this.type = PlayerType.AI;
    }
}
