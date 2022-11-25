package Gameplay.Combat.Configs.LoadTeamConfigs;

public interface LoadTeamConfigs {
    TeamSource getTeamSource();
    TeamLoadOptions[] getTeamLoadOptions();
    int getCreaturesPerTeam();
}
