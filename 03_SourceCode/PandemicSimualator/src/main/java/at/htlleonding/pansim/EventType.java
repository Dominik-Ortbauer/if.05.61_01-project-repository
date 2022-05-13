package at.htlleonding.pansim;

public enum EventType {
    JOB(0.3, 50),
    ESSENTIAL(0.2, 20),
    FESTIVITY(0.6, 200),
    PUBLIC_TRANSPORT(0.9, 25),
    NON_ESSENTIAL(0.5, 20),
    GATHERING(0.7, 30),
    TEST(1, 1);

    private double closeness;
    private int mMaxPeople;

    private EventType(double closeness, int maxPeople) {

        this.closeness = closeness;
        this.mMaxPeople = maxPeople;
    }

    public double getCloseness() {
        return closeness;
    }

    public int getMaxPeople() {
        return mMaxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        mMaxPeople = maxPeople;
    }
}
