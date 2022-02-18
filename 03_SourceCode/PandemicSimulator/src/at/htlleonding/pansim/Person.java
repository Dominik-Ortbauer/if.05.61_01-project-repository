package at.htlleonding.pansim;

public class Person implements Updatable{
    private InfectionState infectionState;
    private double transmitability;
    private double immunitivity;
    private double probOfDeath;
    private boolean quarantined;
    private int timer;

    private void participateInEvent(Event event){

    }

    public Person() {
        this.infectionState = InfectionState.SUSCEPTABLE;
        this.transmitability = 0;
        this.immunitivity = 0;
        // this.probOfDeath = probOfDeath;
        this.quarantined = false;
    }

    private void infect(){
        this.infectionState = InfectionState.INFECTED;
        timer = 10;
    }

    public void vaccinate(){

    }

    private void recover(){
        this.infectionState = InfectionState.RECOVERED;
    }

    @Override
    public void update(int generation) {
        switch (infectionState){
            case INFECTED:
                timer--;
                if (timer <= 0){
                    recover();
                    timer = 180;
                }
                break;
            case RECOVERED:
                timer--;
                if (timer <= 0){
                    infectionState = InfectionState.SUSCEPTABLE;
                }
                break;

        }
    }
}
