package Gameplay.Combat;

public interface CombatConfigInterface {
    int numberCombatants();
    int creaturesPerCombatant();
    int creaturesPerCombatantsSimultaneously();
}

/*
    Combat Sequence:
    1. Load teams
    2. Present starting lineup
    3. Determine attack order
    4. Beginning of turn actions
        4a. Effect actions (burn, adjust stats)
    5. Conduct turn
        5a. Attack
        5b. Swap
        5c. Item
        5d. Escape
        5e. ???
    6. End of turn effects (poison)
    7. Check Status (ensure nothing wrong)
    8. Check win condition achieved

*/

