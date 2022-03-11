package at.htlleonding.pansim;

import java.util.*;

public class City {
    private List<Event> events = new LinkedList<>();
    private List<Person> people = new LinkedList<>();
    private List<Measure> measures = new LinkedList<>();
    private Virus virus;
    private Renderer renderer;
    private int generation;
    private int endGeneration = 365;

    private static City instance = new City(100, 365);

    public static City getInstance() {
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

        Map<InfectionState, Integer> counter = new HashMap();
        counter.put(InfectionState.SUSCEPTABLE, 0);
        counter.put(InfectionState.INFECTED, 0);
        counter.put(InfectionState.RECOVERED, 0);

        for(Person p : people) {
            counter.merge(p.getInfectionState(), 1, Integer::sum);
        }

        System.out.println("Susceptable: " + counter.get(InfectionState.SUSCEPTABLE) + " | Infected: " + counter.get(InfectionState.INFECTED) + " | Recovered: " + counter.get(InfectionState.RECOVERED));
    }

    public void startSimulation(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 1000);
    }

    private void initPeople(int amountOfPeople) {
        for (int i = 0; i < amountOfPeople; i++) {
            people.add(new Person());
        }
    }
}
