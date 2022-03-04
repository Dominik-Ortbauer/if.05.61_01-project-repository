package at.htlleonding.pansim;

public class Randomizer implements RandomGenerateable{
    @Override
    public double rand() {
        return Math.random();
    }
}
