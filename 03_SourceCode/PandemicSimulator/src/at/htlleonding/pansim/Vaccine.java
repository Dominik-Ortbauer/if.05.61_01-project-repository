package at.htlleonding.pansim;

public class Vaccine extends Measure{
    private double effectivity;

    public Vaccine(int startTime, int endTime, double obeynessPercentage, double effectivity) {
        super(startTime, endTime, obeynessPercentage);
        this.effectivity = effectivity;
    }
}
