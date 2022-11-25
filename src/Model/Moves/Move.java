package Model.Moves;

import Data.AttributePair;
import Data.TypeMatchups;
import Model.Moves.PPConfigs.PP;
import Model.TypeAttribute;
import Model.TypeMatchupMultipliers;

import java.util.OptionalInt;

public class Move {
    public String name;
    OptionalInt power;
    OptionalInt fixedDamage;
    Effect<T>[] effects;
    PP pp;
    MoveType moveType;
    AttributePair attributePair;

    public Move(String name, OptionalInt power, OptionalInt fixedDamage, Effect[] effects,
                PP pp, MoveType moveType, AttributePair attributePair) {
        this.name = name;
        this.power = power;
        this.fixedDamage = fixedDamage;
        this.effects = effects;
        this.pp = pp;
        this.moveType = moveType;
        this.attributePair = attributePair;
    }

    public double getAttackMultiplier(AttributePair targetAttribute) {
        TypeAttribute firstType = attributePair.getFirstAttribute();
        TypeAttribute secondType = attributePair.getSecondAttribute();

        TypeAttribute targetFirstType = targetAttribute.getFirstAttribute();
        TypeAttribute targetSecondType = targetAttribute.getSecondAttribute();

        TypeMatchups matchups = new TypeMatchups().getInstance();
        TypeMatchupMultipliers multipliers = new TypeMatchupMultipliers().getInstance();

        return
                multipliers.getMatchupMultiplier(matchups.getMatchup(new AttributePair(firstType, targetFirstType))) *
                        multipliers.getMatchupMultiplier(matchups.getMatchup(new AttributePair(firstType, targetSecondType))) *
                        multipliers.getMatchupMultiplier(matchups.getMatchup(new AttributePair(secondType, targetFirstType))) *
                        multipliers.getMatchupMultiplier(matchups.getMatchup(new AttributePair(secondType, targetSecondType)));
    }

    public double getStabMultiplier(AttributePair otherAttributePair) {
        int matchingAttributes = attributePair.countMatchingAttributes(otherAttributePair);
        return Math.pow(1.5, matchingAttributes);
    }

    public MoveType getMoveType() { return moveType; }
    public OptionalInt getFixedDamage() { return fixedDamage; }

    public int getPower() { return power.orElse(0); }
    public PP getPP() { return pp; }

    public Effect[] getEffects() {
        return effects;
    }
}

