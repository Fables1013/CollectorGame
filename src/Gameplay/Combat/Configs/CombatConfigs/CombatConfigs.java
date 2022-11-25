package Gameplay.Combat.Configs.CombatConfigs;

import Gameplay.Combat.Configs.DefaultConfigs.LoadTeamConfigDefault;
import Gameplay.Combat.Configs.DefaultConfigs.VictoryConditionConfigDefault;
import Gameplay.Combat.Configs.LoadTeamConfigs.LoadTeamConfigs;
import Gameplay.Combat.Configs.VictoryConditionConfigs.VictoryConditionConfigs;

public class CombatConfigs {
    public LoadTeamConfigs loadTeamConfigs;
    public VictoryConditionConfigs victoryConditionConfigs;

    public CombatConfigs() {
        this.loadTeamConfigs = new LoadTeamConfigDefault();
        this.victoryConditionConfigs = new VictoryConditionConfigDefault();
    }
}
