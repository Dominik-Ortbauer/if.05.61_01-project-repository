package at.htlleonding.pansim;

public class Person {
    private InfectionState infectionState;
    private double transmitability;
    private double immunitivity; //
    private double probOfDeath;
    private boolean qurantined;

    private void participateInEvent(Event event){

    }

    public Person() {
        this.infectionState = InfectionState.SUSCEPTABLE;
        this.transmitability = 0;
        this.immunitivity = 0;
        // this.probOfDeath = probOfDeath;
        this.qurantined = false;
    }

    /*
    eventProb is the probability to catch the virus when being on a specific event
    measuresEffect is how effective the measures are. It reduces the eventProb
     */
    private void infect(double eventProb, double measuresEffect){
        double probability = eventProb * Virus.infectousness * (1 - immunitivity) * (1 - measuresEffect);

        
        if(probability >= new Randomizer().rand())
        this.infectionState = InfectionState.INFECTED;
    }

    public void vaccinate(){

    }

    private void recover(){

    }

    public void update(){

    }
}
