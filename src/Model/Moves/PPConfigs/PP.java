package Model.Moves.PPConfigs;

abstract public class PP {
    int[] availabilityProgression;
    int currentPP;
    int maxPP;
    int upgrades;

    public void resetPP() {currentPP = maxPP;}
    public void upgrade() { if (this.upgrades < availabilityProgression.length) this.upgrades++; }
}

