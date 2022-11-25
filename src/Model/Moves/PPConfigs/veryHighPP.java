package Model.Moves.PPConfigs;

public class veryHighPP extends PP {
    private static final veryHighPP instance = new veryHighPP();

    public veryHighPP() {
        this.availabilityProgression = new int[]{25, 30, 35, 40};
    }

    public static veryHighPP getInstance() {
        return instance;
    }

}
