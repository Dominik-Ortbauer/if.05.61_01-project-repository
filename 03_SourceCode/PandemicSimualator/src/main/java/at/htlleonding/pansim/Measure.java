package at.htlleonding.pansim;

public class Measure {
    private double obeynessPercentage;
    private int duration;

    public Measure(int duration, double obeynessPercentage){
        this.duration = duration;
        this.obeynessPercentage = obeynessPercentage;
    }

    public int getDuration() {
        return duration;
    }

    public void setStartTime(int duration) {
        this.duration = duration;
    }

}
