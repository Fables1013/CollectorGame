package Model;

public class TypeMatchupMultipliers {

    public TypeMatchupMultipliers() {}
    private static TypeMatchupMultipliers instance = new TypeMatchupMultipliers();

    public TypeMatchupMultipliers getInstance() { return instance; }

    public double getMatchupMultiplier(TypeMatchup typeMatchup) {
        return switch (typeMatchup) {
            case SuperEffective -> 2.0;
            case Ineffective -> 0.5;
            case Normal -> 1.0;
            case Immune -> 0.0;
        };
    }
}
