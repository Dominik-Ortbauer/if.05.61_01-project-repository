package at.htlleonding.pansim;

public class Vaccine extends Measure{
    private double effectivity;

    public Vaccine(int duration, double obeynessPercentage, double effectivity) {
        super(duration, obeynessPercentage);
        this.effectivity = effectivity;
    }
}
