package at.htlleonding.pansim;

public class Person {
    private InfectionState infectionState;
    private double transmitability;
    private double immunitivity;
    private double probOfDeath;
    private boolean qurantined;

    public Person(){

    }

    private void participateInEvent(Event event){

    }

    public Person() {
        this.infectionState = InfectionState.SUSCEPTABLE;
        this.transmitability = 0;
        this.immunitivity = 0;
        // this.probOfDeath = probOfDeath;
        this.qurantined = false;
    }

    private void infect(){
        this.infectionState = InfectionState.INFECTED;
    }

    public void vaccinate(){

    }

    private void recover(){

    }

    public void update(){

    }
}
