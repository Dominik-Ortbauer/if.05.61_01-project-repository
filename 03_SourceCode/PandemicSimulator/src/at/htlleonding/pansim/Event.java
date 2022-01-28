package at.htlleonding.pansim;

import java.util.LinkedList;

public class Event {
    private LinkedList<Person> people;
    private double infectionRate;
    private EventType eventType;

    public Event(LinkedList<Person> people, double closeness, EventType eventType){
        this.people = people;
        this.infectionRate = calculateInfectionRate(closeness);
        this.eventType = eventType;
    }

    private double calculateInfectionRate(double closeness) {
        return closeness;
    }

    public void join(Person person, int duration){
        people.add(person);
    }

    public void leave(Person person){
        people.remove(person);
    }
}
