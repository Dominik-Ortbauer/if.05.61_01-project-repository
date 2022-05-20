package at.htlleonding.pansim;

import java.util.List;

public class Lockdown extends Measure {
    private static Lockdown instance;

    private EventType[] closedEventTypes;
    private InfectionState[] effectedInfectionStates;

    public boolean isActive = false;

    private Lockdown(int duration, double obeynessPercentage, EventType[] closedEventTypes, InfectionState[] effectedInfectionStates) {
        super(duration, obeynessPercentage);
        this.closedEventTypes = closedEventTypes;
        this.effectedInfectionStates = effectedInfectionStates;
    }

    public static Lockdown newLockdown(int duration, double obeynessPercentage, EventType[] closedEventTypes, InfectionState[] effectedInfectionStates){
        if(instance == null){
            instance = new Lockdown(duration, obeynessPercentage, closedEventTypes, effectedInfectionStates);
        }
        else{
            instance.setValues(duration, obeynessPercentage, closedEventTypes, effectedInfectionStates);
        }
        return instance;
    }

    private void setValues(int duration, double obeynessPercentage, EventType[] closedEventTypes, InfectionState[] effectedInfectionStates){
        this.duration = duration;
        this.obeynessPercentage = obeynessPercentage;
        this.closedEventTypes = closedEventTypes;
        this.effectedInfectionStates = effectedInfectionStates;
    }

    public void start(List<Event> events){
        for (Event e : events) {
            boolean closes = false;
            for (EventType et : closedEventTypes) {
                if(e.getEventType() == et){
                    closes = true;
                }
            }
            if (closes) {
                e.close(events);
            }
        }
        isActive = true;
    }

    public boolean isActive(){
        return isActive;
    }
}
