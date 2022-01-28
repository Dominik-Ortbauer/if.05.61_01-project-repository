package at.htlleonding.pansim;

public class Lockdown extends Measure {
    private EventType[] closedEventTypes;
    private InfectionState[] effectedInfectionStates;

    public Lockdown(int startTime, int endTime, double obeynessPercentage, EventType[] closedEventTypes, InfectionState[] effectedInfectionStates) {
        super(startTime, endTime, obeynessPercentage);
        this.closedEventTypes = closedEventTypes;
        this.effectedInfectionStates = effectedInfectionStates;
    }
}
