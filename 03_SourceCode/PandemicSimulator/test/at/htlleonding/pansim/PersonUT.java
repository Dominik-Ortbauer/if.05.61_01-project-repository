package at.htlleonding.pansim;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonUT {
    @Test
    void PersonShouldBeSusceptableAfterInitializing(){
        Person person = new Person();
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
    }
}
