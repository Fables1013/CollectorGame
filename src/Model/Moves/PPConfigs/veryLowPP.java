package Model.Moves.PPConfigs;

public class veryLowPP extends PP {
    private static final veryLowPP instance = new veryLowPP();

    public veryLowPP() {
        this.availabilityProgression = new int[]{5, 6, 7, 8};
    }

    public static veryLowPP getInstance() {
        return instance;
    }

}
