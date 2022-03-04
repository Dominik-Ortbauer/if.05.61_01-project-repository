package at.htlleonding.pansim;

import java.util.HashMap;
import java.util.LinkedList;

public class Event {
    private HashMap<Person, Integer> people;
    private double infectionRate;
    private EventType eventType;

    public Event(HashMap<Person, Integer> people, double closeness, EventType eventType){
        this.people = people;
        this.infectionRate = calculateInfectionRate(closeness);
        this.eventType = eventType;
    }

    private double calculateInfectionRate(double closeness) {
        //Transmitability of the person thats infected. If there are multiple people infected, take that into consideration somehow as well
        return closeness;
    }

    public void join(Person person, int duration){
        people.put(person, duration);
    }

    public void leave(Person person){
        people.remove(person);
    }

    public void update(){

    }
}
