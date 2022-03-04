package at.htlleonding.pansim;

import java.util.HashMap;

public class Event implements Updatable {
    private HashMap<Person, Integer> people;
    private double infectionRate;
    private EventType eventType;

    public Event(EventType eventType){
        this.infectionRate = calculateInfectionRate(eventType);
        this.eventType = eventType;
        people = new HashMap<>();
    }

    private double calculateInfectionRate(EventType eventType) {
        return eventType.getCloseness();
    }

    public void join(Person person, int duration){
        people.put(person, duration);
    }

    public void leave(Person person){
        people.remove(person);
    }

    public void update(int generation){

    }
}
