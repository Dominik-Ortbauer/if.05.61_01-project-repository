package at.htlleonding.pansim;

public class Lockdown extends Measure {
    private EventType[] closedEventTypes;
    private InfectionState[] effectedInfectionStates;

    public Lockdown(int duration, double obeynessPercentage, EventType[] closedEventTypes, InfectionState[] effectedInfectionStates) {
        super(duration, obeynessPercentage);
        this.closedEventTypes = closedEventTypes;
        this.effectedInfectionStates = effectedInfectionStates;
    }
}
