package Data;

import Model.Moves.MoveType;
import Model.TypeAttribute;
import Model.TypeMatchup;
import org.w3c.dom.Attr;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TypeMatchups {

    HashMap<AttributePair, TypeMatchup> matchups = new HashMap<>();
    public TypeMatchups(){ setDefaultMatchups(); }

    private static final TypeMatchups instance = new TypeMatchups();
    public TypeMatchups getInstance() { return instance; }

    public TypeMatchup getMatchup(AttributePair pair) { return matchups.getOrDefault(pair, TypeMatchup.Normal); }
    private void setDefaultMatchups() {
        // Normal
        this.matchups.put(new AttributePair(TypeAttribute.Normal, TypeAttribute.Ghost), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Normal, TypeAttribute.Rock), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Normal, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Fire
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Water), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Grass), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Bug), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Ice), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Fire), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Rock), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Dragon), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fire, TypeAttribute.Steel), TypeMatchup.SuperEffective);

        // Water
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Fire), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Water), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Ground), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Rock), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Grass), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Water, TypeAttribute.Dragon), TypeMatchup.Ineffective);

        // Electric
        this.matchups.put(new AttributePair(TypeAttribute.Electric, TypeAttribute.Ground), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Electric, TypeAttribute.Electric), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Electric, TypeAttribute.Dragon), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Electric, TypeAttribute.Flying), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Electric, TypeAttribute.Water), TypeMatchup.SuperEffective);

        // Grass
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Water), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Flying), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Bug), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Fire), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Ground), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Rock), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Dragon), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Grass, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Ghost
        this.matchups.put(new AttributePair(TypeAttribute.Ghost, TypeAttribute.Normal), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Ghost, TypeAttribute.Psychic), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ghost, TypeAttribute.Dark), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ghost, TypeAttribute.Ghost), TypeMatchup.SuperEffective);

        // Fighting
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Normal), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Flying), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Dark), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Ghost), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Rock), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Ice), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Psychic), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fighting, TypeAttribute.Steel), TypeMatchup.SuperEffective);

        // Ground
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Rock), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Electric), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Grass), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Poison), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Flying), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Ground, TypeAttribute.Steel), TypeMatchup.SuperEffective);

        // Ice
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Grass), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Ground), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Water), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Flying), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Fire), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Dragon), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Ice, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Dragon
        this.matchups.put(new AttributePair(TypeAttribute.Dragon, TypeAttribute.Fairy), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Dragon, TypeAttribute.Dragon), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Dragon, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Psychic
        this.matchups.put(new AttributePair(TypeAttribute.Psychic, TypeAttribute.Dark), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Psychic, TypeAttribute.Poison), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Psychic, TypeAttribute.Psychic), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Psychic, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Dark
        this.matchups.put(new AttributePair(TypeAttribute.Dark, TypeAttribute.Psychic), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Dark, TypeAttribute.Ghost), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Dark, TypeAttribute.Steel), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Dark, TypeAttribute.Dark), TypeMatchup.Ineffective);

        // Steel
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Fairy), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Rock), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Ice), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Fire), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Electric), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Steel, TypeAttribute.Water), TypeMatchup.Ineffective);

        // Poison
        this.matchups.put(new AttributePair(TypeAttribute.Poison, TypeAttribute.Fairy), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Poison, TypeAttribute.Steel), TypeMatchup.Immune);
        this.matchups.put(new AttributePair(TypeAttribute.Poison, TypeAttribute.Grass), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Poison, TypeAttribute.Ground), TypeMatchup.Ineffective);

        // Fairy
        this.matchups.put(new AttributePair(TypeAttribute.Fairy, TypeAttribute.Fairy), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fairy, TypeAttribute.Dragon), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fairy, TypeAttribute.Poison), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Fairy, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Bug
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Grass), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Fire), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Poison), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Psychic), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Dark), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Fighting), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Flying), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Bug, TypeAttribute.Steel), TypeMatchup.Ineffective);

        // Rock
        this.matchups.put(new AttributePair(TypeAttribute.Rock, TypeAttribute.Flying), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Rock, TypeAttribute.Ice), TypeMatchup.SuperEffective);
        this.matchups.put(new AttributePair(TypeAttribute.Rock, TypeAttribute.Fighting), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Rock, TypeAttribute.Steel), TypeMatchup.Ineffective);
        this.matchups.put(new AttributePair(TypeAttribute.Rock, TypeAttribute.Bug), TypeMatchup.SuperEffective);

    }
}

