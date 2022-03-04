package at.htlleonding.pansim;

import java.util.HashMap;
import java.util.LinkedList;

public class Event implements Updatable {
    private HashMap<Person, Integer> people;
    private double infectionRate;
    private EventType eventType;

    public Event(HashMap<Person, Integer> people, double closeness, EventType eventType){
        this.people = people;
        this.infectionRate = calculateInfectionRate(closeness);
        this.eventType = eventType;
    }

    private double calculateInfectionRate(double closeness) {
        return closeness;
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
