package Gameplay.Combat.Controller;

import Model.Items.Item;
import Model.PlayerTypes.Trainer;
import Model.Team;

import java.util.UUID;

public class CombatPlayer {
    public Team team;
    public Item[] items;
    public String name;
    public double money;
    public UUID id;

    public PlayerType playerType;

    public CombatPlayer(Team team, Item[] items, String name, double money, UUID id, PlayerType playerType) {
        this.team = team;
        this.items = items;
        this.name = name;
        this.money = money;
        this.id = id;
        this.playerType = playerType;
    }

    public CombatPlayer(Trainer trainer, Team combatTeam) {
        this.team = combatTeam;
        this.items = trainer.items;
        this.name = trainer.name;
        this.id = trainer.id;
    }
}
