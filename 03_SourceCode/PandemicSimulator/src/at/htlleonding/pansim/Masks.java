package at.htlleonding.pansim;

public class Masks extends Measure {
    private double effectivity;

    public Masks(int startTime, int endTime, double obeynessPercentage, double effectivity) {
        super(startTime, endTime, obeynessPercentage);
        this.effectivity = effectivity;
    }

    public double getEffectivity() {
        return effectivity;
    }

    public void setEffectivity(double effectivity) {
        this.effectivity = effectivity;
    }
}
