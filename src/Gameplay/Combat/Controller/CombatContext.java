package Gameplay.Combat.Controller;

import Gameplay.Combat.CombatPhases.TurnActions.TurnAction;
import Model.Battlefield;
import Model.Creature_Configs.Creature;
import Model.PlayerTypes.Combatant;

import java.util.LinkedList;

public class CombatContext {
    Combatant[] players;

    Battlefield battlefield;
    Combatant activePlayer;
    Creature activeCreature;
    TurnAction currentAction;

    public CombatContext(Combatant[] players, Battlefield battlefield) {
        this.players = players;
        this.battlefield = battlefield;
    }
    public Combatant[] getPlayers() { return players; }
    public void setBattlefield(Battlefield battlefield) { this.battlefield = battlefield; }
    public Battlefield getBattlefield() { return this.battlefield; }

    public LinkedList<Creature> getActiveCreaturesForPlayer(Combatant combatPlayer) {
        return battlefield.getCreaturesOnBattlefield(combatPlayer);
    }

    public void setPlayers(Combatant[] players) {
        this.players = players;
    }

    public Combatant getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Combatant activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Creature getActiveCreature() {
        return activeCreature;
    }

    public void setActiveCreature(Creature activeCreature) {
        this.activeCreature = activeCreature;
    }

    public TurnAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(TurnAction currentAction) {
        this.currentAction = currentAction;
    }
}
