package at.htlleonding.pansim;

import at.htlleonding.App;

import java.util.*;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

public class City {
    private List<Event> events = new LinkedList<>();
    private List<Person> people = new LinkedList<>();
    private List<Measure> measures = new LinkedList<>();
    private Virus virus;
    private int generation;
    private int endGeneration = 200;
    private Timer timer;
    private int testQuantity = 3500;
    private static int amountOfPeople = 20000;

    private static City instance = new City(amountOfPeople, 25, 365);

    public static City getInstance() {
        return instance;
    }

    private City(int amountOfPeople, int infectedAmount, int endGeneration) {
        generation = 0;
        virus = new Virus();
        this.endGeneration = endGeneration;

        events.add(new Event(EventType.PUBLIC_TRANSPORT));
        events.add(new Event(EventType.ESSENTIAL));
        events.add(new Event(EventType.FESTIVITY));
        events.add(new Event(EventType.GATHERING));
        events.add(new Event(EventType.JOB));
        events.add(new Event(EventType.NON_ESSENTIAL));

        initPeople(amountOfPeople, infectedAmount);
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

        /*
        EventType[] eventsToClose = {EventType.FESTIVITY, EventType.GATHERING, EventType.NON_ESSENTIAL};
        InfectionState[] effectedPeople = {InfectionState.INFECTED, InfectionState.RECOVERED, InfectionState.SUSCEPTABLE};
        Lockdown lockdown = Lockdown.newLockdown(21, 0.75, eventsToClose, effectedPeople);
        if(counter.get(InfectionState.INFECTED) > 3000 && lockdown.isActive()){
            lockdown.start(events);
        }
         */
        if (counter.get(InfectionState.INFECTED ) > amountOfPeople/2){
            for (int i = new Random().nextInt(testQuantity); i < people.size(); i+= testQuantity){
                people.get(i).testPerson();
            }
        }
        System.out.println("Susceptable: " + counter.get(InfectionState.SUSCEPTABLE) + " | Infected: " + counter.get(InfectionState.INFECTED) + " | Recovered: " + counter.get(InfectionState.RECOVERED));

        Platform.runLater(() -> {
            App.primaryViewController.suseptableChart.getData().add(new XYChart.Data<>(generation, counter.get(InfectionState.SUSCEPTABLE)));
            App.primaryViewController.infectedChart.getData().add(new XYChart.Data<>(generation, counter.get(InfectionState.INFECTED)));
            App.primaryViewController.recoveredChart.getData().add(new XYChart.Data<>(generation, counter.get(InfectionState.RECOVERED)));

            App.primaryViewController.setEventTextArea(events);
        });


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
        }, 0, 10);
    }

    private void initPeople(int amountOfPeople, int infectedAmount) {
        for (int i = 0; i < amountOfPeople; i++) {
            Person p = new Person();
            if(i < infectedAmount) {
                p.infect();
            }
            joinRandomEvent(p);
            people.add(p);
        }

        //initEvents(mPerson);
        //people.add(mPerson);
        //mPerson.participateInEvent(new Event(EventType.NON_ESSENTIAL));
    }

    Person mPerson = new TestPerson();

    public void initEvents(Person p) {
        boolean joined = false;
        for(Event e : events) {
            joined = joined || e.joinInit(p, 1);
        }

        if(!joined) {
            Event e = new Event(EventType.values()[(int) (Math.random() * EventType.values().length)]);
            e.join(p, 1);
            events.add(e);
        }
    }

    public void joinRandomEvent(Person p) {
        Collections.shuffle(events);

        boolean joined = false;
        for(Event e : events) {
            joined = joined || p.participateInEvent(e);
        }

        if(!joined) {
            Event e = new Event(EventType.values()[(int) (Math.random() * EventType.values().length)]);
            p.participateInEvent(e);
            events.add(e);
        }
    }
}
