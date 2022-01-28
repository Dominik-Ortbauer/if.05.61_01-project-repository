package at.htlleonding.pansim;

import java.util.LinkedList;
import java.util.List;

public class City {
    private List<Event> events = new LinkedList<>();
    private List<Person> people = new LinkedList<>();
    private Virus virus;
    private Renderer renderer;
    private int generation;

    private void update(){

    }

    public void startSimulation(int generation){

    }
}
