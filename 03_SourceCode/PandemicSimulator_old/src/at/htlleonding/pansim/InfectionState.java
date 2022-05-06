package at.htlleonding.pansim;

public enum InfectionState  {
    SUSCEPTABLE(-1, 0),
    INFECTED(10, 1),
    RECOVERED(180, 0);

    int duration;
    private double transmitability;

    InfectionState(int duration, double transmitability){
        this.duration = duration;
        this.transmitability = transmitability;
    }

    public double getTransmitability(){
        return transmitability;
    }
}
