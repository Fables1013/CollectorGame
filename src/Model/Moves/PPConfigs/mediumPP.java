package Model.Moves.PPConfigs;

public class mediumPP extends PP {
    private static final mediumPP instance = new mediumPP();

    public mediumPP() {
        this.availabilityProgression = new int[]{15, 18, 21, 24};
    }

    public static mediumPP getInstance() {
        return instance;
    }

}
