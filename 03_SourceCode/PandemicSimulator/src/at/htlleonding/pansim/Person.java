package at.htlleonding.pansim;

public class Person implements Updatable{
    private InfectionState infectionState;
    private double immunitivity;
    private double probOfDeath;
    private boolean quarantined;
    private int timer;
    private int quarantineTimer;

    private void participateInEvent(Event event){

    }

    public InfectionState getInfectionState() {
        return infectionState;
    }

    public Person() {
        this.infectionState = InfectionState.SUSCEPTABLE;
        this.immunitivity = 0;
        // this.probOfDeath = probOfDeath;
        this.quarantined = false;
    }

    /*
    eventProb is the probability to catch the virus when being on a specific event
    measuresEffect is how effective the measures are. It reduces the eventProb
     */
    public void infect(){
        if(new Randomizer().rand() > immunitivity){
            this.infectionState = InfectionState.INFECTED;
        }
        timer = 10;
    }

    public void vaccinate(Vaccine vac){
        immunitivity += vac.getEffectivity();
        if(immunitivity > 1) immunitivity = 1;
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
                    timer = infectionState.duration;
                }
                break;
            case RECOVERED:
                timer--;
                if (timer <= 0){
                    infectionState = InfectionState.SUSCEPTABLE;
                }
                break;

        }
        if (quarantined){
            if (quarantineTimer <= 0){
                this.quarantined = false;
            }
        }
    }
}
