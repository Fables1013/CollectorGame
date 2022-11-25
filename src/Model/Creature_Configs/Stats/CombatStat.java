package Model.Creature_Configs.Stats;

public class CombatStat {
    int baseStat;
    int modifier;
    int finalStat;
    boolean hasStatusDrag;

    public CombatStat(int baseStat, int modifier){
        this.baseStat = baseStat;
        this.modifier = modifier;
        recalculateFinalStat();
    }

    public void setModifier(int level) {
        this.modifier = Math.min(Math.max(-6, level), 6);
        recalculateFinalStat();
    }

    public void changeModifier(int change) {
        setModifier(modifier + change);
    }

    public void recalculateFinalStat() { this.finalStat = (int) (baseStat * calcStatAdjustmentFromModifier() * getStatusMultiplier()); }

    public void setStatus(boolean status) { this.hasStatusDrag = status; }
    private double getStatusMultiplier() { if (hasStatusDrag) return 0.5; else return 1.0; }
    public double calcStatAdjustmentFromModifier() {
        // modifier in range [-6, 6, 1]. adjustment in range [2/8 	2/7 	2/6 	2/5 	2/4 	2/3 	2/2 	3/2 	4/2 	5/2 	6/2 	7/2 	8/2]
        if (modifier < 0)
            return 2.0 / (2.0 + Math.abs(modifier));
        else
            return (modifier + 2.0) / 2.0;
    }
}
