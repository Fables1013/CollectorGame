package Model.Moves.PPConfigs;

public class lowPP extends PP {
    private static final lowPP instance = new lowPP();

    public lowPP() {
        this.availabilityProgression = new int[]{10, 12, 14, 16};
    }

    public static lowPP getInstance() {
        return instance;
    }

}
