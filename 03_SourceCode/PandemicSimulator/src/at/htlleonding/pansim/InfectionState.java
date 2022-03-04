package at.htlleonding.pansim;

public enum InfectionState  {
    SUSCEPTABLE(-1),
    INFECTED(10),
    RECOVERED(180);

    int duration;
    InfectionState(int duration){
        this.duration = duration;
    }
}
