package Gameplay.Combat;

public class DefaultCombatConfigs implements CombatConfigInterface {

    int numCombatants = 2;
    private DefaultCombatConfigs() {}

    private final DefaultCombatConfigs instance = new DefaultCombatConfigs();
    public DefaultCombatConfigs getInstance() { return instance; }

    @Override
    public int numberCombatants() { return 2; }

    @Override
    public int creaturesPerCombatant() { return 6; }

    @Override
    public int creaturesPerCombatantsSimultaneously() { return 1; }
}
