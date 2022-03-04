package at.htlleonding.pansim;

import java.util.LinkedList;
import java.util.List;

public class City {
    private List<Event> events = new LinkedList<>();
    private List<Person> people = new LinkedList<>();
    private List<Measure> measures = new LinkedList<>();
    private Virus virus;
    private Renderer renderer;
    private int generation;
    private int endGeneration = 365;

    private static City instance = new City(100, 365);

    public City getInstance() {
        return instance;
    }

    private City(int amountOfPeople, int endGeneration) {
        generation = 0;
        virus = new Virus();
        this.endGeneration = endGeneration;

        initPeople(amountOfPeople);
    }

    private void update(){
        for(generation = 0; generation < endGeneration; generation++) {
            for(Person p : people) {
                p.update(generation);
            }

            for(Event e : events) {
                e.update(generation);
            }
        }
    }

    public void startSimulation(){
        update();
    }

    private void initPeople(int amountOfPeople) {
        for (int i = 0; i < amountOfPeople; i++) {
            people.add(new Person());
        }
    }
}
