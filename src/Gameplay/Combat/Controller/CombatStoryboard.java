package Gameplay.Combat.Controller;

import Gameplay.Combat.CombatPhases.CombatPhase;

import java.util.LinkedList;

// Represents the sequence of events that needs to happen in a given turn
public class CombatStoryboard {
    LinkedList<CombatPhase> storyboard;

    public void pushCombatPhase(CombatPhase cp) { storyboard.push(cp); }
    public CombatPhase popCombatPhase() { return storyboard.pop(); }
    public void moveToNextPhase() {  }
    public Boolean isEmpty () { return storyboard.isEmpty(); }
}
