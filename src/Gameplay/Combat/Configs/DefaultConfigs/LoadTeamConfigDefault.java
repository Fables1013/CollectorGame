package Gameplay.Combat.Configs.DefaultConfigs;

import Gameplay.Combat.Configs.LoadTeamConfigs.LoadTeamConfigs;
import Gameplay.Combat.Configs.LoadTeamConfigs.TeamLoadOptions;
import Gameplay.Combat.Configs.LoadTeamConfigs.TeamSource;

public class LoadTeamConfigDefault implements LoadTeamConfigs {

    public LoadTeamConfigDefault() {}
    @Override
    public TeamSource getTeamSource() { return TeamSource.PARTY; }

    @Override
    public TeamLoadOptions[] getTeamLoadOptions() { return new TeamLoadOptions[]{TeamLoadOptions.UNCHANGED}; }

    @Override
    public int getCreaturesPerTeam() { return 6; }
}
