package at.htlleonding.pansim;

public class Measure {
    private double obeynessPercentage;
    private int startTime;
    private int endTime;

    public Measure(int startTime, int endTime, double obeynessPercentage){
        this.startTime = startTime;
        this.endTime = endTime;
        this.obeynessPercentage = obeynessPercentage;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
