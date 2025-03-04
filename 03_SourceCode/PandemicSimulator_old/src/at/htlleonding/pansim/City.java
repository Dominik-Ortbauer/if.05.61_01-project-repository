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
    private Timer timer;

    private static City instance = new City(100, 365);

    public static City getInstance() {
        return instance;
    }

    private City(int amountOfPeople, int endGeneration) {
        generation = 0;
        virus = new Virus();
        this.endGeneration = endGeneration;

        events.add(new Event(EventType.PUBLIC_TRANSPORT));
        events.add(new Event(EventType.ESSENTIAL));
        events.add(new Event(EventType.FESTIVITY));
        events.add(new Event(EventType.GATHERING));
        events.add(new Event(EventType.JOB));
        events.add(new Event(EventType.NON_ESSENTIAL));

        initPeople(amountOfPeople);
    }

    private void update(){
        for(Person p : people) {
            p.update(generation);
        }

        for(Event e : events) {
            e.update(generation);
        }

        Map<InfectionState, Integer> counter = new HashMap();
        counter.put(InfectionState.SUSCEPTABLE, 0);
        counter.put(InfectionState.INFECTED, 0);
        counter.put(InfectionState.RECOVERED, 0);

        for(Person p : people) {
            counter.merge(p.getInfectionState(), 1, Integer::sum);
        }

        System.out.println("Susceptable: " + counter.get(InfectionState.SUSCEPTABLE) + " | Infected: " + counter.get(InfectionState.INFECTED) + " | Recovered: " + counter.get(InfectionState.RECOVERED));

        generation++;

        if(generation > endGeneration) {
            timer.cancel();
            timer = null;
        }
    }

    public void startSimulation(){
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 1000);
    }

    private void initPeople(int amountOfPeople) {
        for (int i = 0; i < amountOfPeople; i++) {
            Person p = new Person();
            if(new Random().nextDouble() < 0.25d) {
                p.infect();
            }
            joinRandomEvent(p);
            people.add(p);
        }
    }

    public void joinRandomEvent(Person p) {
        Event e = events.get(new Random().nextInt(events.size()));
        e.join(p, 5);
    }
}
