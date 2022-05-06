package at.htlleonding.pansim;

public enum EventType {
    JOB(0.3),
    ESSENTIAL(0.2),
    FESTIVITY(0.6),
    PUBLIC_TRANSPORT(0.9),
    NON_ESSENTIAL(0.5),
    GATHERING(0.7),
    TEST(1);

    private double closeness;

    private EventType(double closeness) {

        this.closeness = closeness;
    }

    public double getCloseness() {
        return closeness;
    }
}
