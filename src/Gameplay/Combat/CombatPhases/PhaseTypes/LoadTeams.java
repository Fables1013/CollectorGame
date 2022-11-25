package Gameplay.Combat.CombatPhases.PhaseTypes;

import Gameplay.Combat.CombatPhases.CombatPhase;
import Gameplay.Combat.Configs.LoadTeamConfigs.LoadTeamConfigs;
import Gameplay.Combat.Configs.LoadTeamConfigs.TeamSource;
import Gameplay.Combat.Controller.CombatContext;
import Model.PlayerTypes.Trainer;
import Model.Team;

public class LoadTeams extends CombatPhase {
    PhaseType type = PhaseType.LoadTeams;

    public void loadTeams(LoadTeamConfigs config, CombatContext context) {
        TeamSource source = config.getTeamSource();
    }

    public Team loadTeamFromPlayer(Trainer trainer) {
        return trainer.team;
    }
}
