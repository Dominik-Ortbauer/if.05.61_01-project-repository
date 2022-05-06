package at.htlleonding.pansim;

import java.util.HashMap;
import java.util.Random;

public class Event implements Updatable {
    private HashMap<Person, Integer> people = new HashMap<>(); //the integer is the duration for which the person is in the event
    private double infectionRate;
    private EventType eventType;

    public Event(EventType eventType){
        this.infectionRate = calculateInfectionRate(eventType);
        this.eventType = eventType;
        people = new HashMap<>();
    }

    private double calculateInfectionRate(EventType eventType) {
        /*
            is influenced by transmitability of the infected people, the measures
            and probably some other stuff as well, but I'm not sure what
         */
        double infectionRates = 0;

        for (Person person : people.keySet()) {
            infectionRates += person.getTransmitability();
        }

        return (infectionRates/people.keySet().size()) * eventType.getCloseness();
    }

    public void join(Person person, int duration){
        people.put(person, duration);
        infectionRate = calculateInfectionRate(eventType);
    }

    public void leave(Person person){
        people.remove(person);
        person.leaveEvent();
        infectionRate = calculateInfectionRate(eventType);
    }

    public void update(int generation){
        for(int i = people.size()-1; i >= 0; i--){
            Person person = people.keySet().toArray(new Person[0])[i];
            people.put(person, people.get(person) - 1);
            if (people.get(person) == 0) {
                leave(person);
            }
        }

        infectionRate = calculateInfectionRate(eventType);

        for(Person person : people.keySet()){
            if(new Random().nextDouble() < infectionRate){
                person.infect();
            }
        }
    }
}
