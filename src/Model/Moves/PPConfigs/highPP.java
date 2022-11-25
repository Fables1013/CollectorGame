package Model.Moves.PPConfigs;

public class highPP extends PP {
    int upgrades;
    int maxPP;
    private static final highPP instance = new highPP(0);

    public highPP(int upgrades) {
        this.upgrades = upgrades;
        this.availabilityProgression = new int[]{20, 24, 28, 32};
        this.maxPP = availabilityProgression[upgrades];
    }

    public static highPP getInstance() {
        return instance;
    }

}
