package at.htlleonding.pansim;

public class Masks extends Measure {
    private double effectivity;

    public Masks(int duration, double obeynessPercentage, double effectivity) {
        super(duration, obeynessPercentage);
        this.effectivity = effectivity;
    }

    public double getEffectivity() {
        return effectivity;
    }

    public void setEffectivity(double effectivity) {
        this.effectivity = effectivity;
    }
}
