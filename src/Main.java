import Data.MoveModels.MoveModels;
import Gameplay.Combat.Controller.CombatController;
import Model.Creature_Configs.*;
import Model.Creature_Configs.Metadata.Gender;
import Model.Items.Item;
import Model.Moves.Move;
import Model.PlayerTypes.Combatant;
import Model.PlayerTypes.HumanTrainer;
import Model.PlayerTypes.WildCreature;
import Model.Team;

import java.util.UUID;

import static Data.CreatureModels.CreatureModelConfigs.LunaTuna;

public class Main {
    public static void main(String[] args) {

        Creature myTuna = new Creature(
                LunaTuna,
                "Luna Tuna 123",
                Gender.Male,
                new Moveset(new Move[]{MoveModels.tackle, MoveModels.flamethrower, MoveModels.growl}),
                Status.NONE,
//                new Health(100, 80),
                15
        );

        Creature theirTuna = new Creature(
                LunaTuna,
                "Wild Luna Tuna",
                Gender.Male,
                new Moveset(new Move[]{MoveModels.tackle, MoveModels.flamethrower, MoveModels.growl}),
                Status.NONE,
//                new Health(100, 80),
                5
        );

        Team localTeam = new Team(
                new Creature[]{myTuna}
        );
        Team wildTeam = new Team(
                new Creature[]{theirTuna}
        );

        Combatant local = new HumanTrainer(localTeam, new Item[]{}, "Me", 0, UUID.randomUUID());
        Combatant ai = new WildCreature(wildTeam);

        CombatController controller = new CombatController(new Combatant[]{local, ai});

        controller.runBattle();
    }
}