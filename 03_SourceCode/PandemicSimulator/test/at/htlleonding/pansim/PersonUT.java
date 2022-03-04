package at.htlleonding.pansim;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonUT {
    @Test
    void PersonShouldBeSusceptibleAfterInitializing(){
        Person person = new Person();
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
    }

    @Test
    void PersonShouldBeInfectedAfterGettingTheVirus(){
        Person person = new Person();
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
        person.infect();
        Assertions.assertEquals(InfectionState.INFECTED, person.getInfectionState());
    }

    @Test
    void PersonShouldBeRecoveredAfterHavingTheVirus(){
        Person person = new Person();
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
        person.infect();
        Assertions.assertEquals(InfectionState.INFECTED, person.getInfectionState());
        for (int i = 0; i <= 10; i++){
            person.update(0);
        }
        Assertions.assertEquals(InfectionState.RECOVERED, person.getInfectionState());
    }

    @Test
    void PersonShouldBeSusceptibleAfterBeingRecoveredFor180Days(){
        Person person = new Person();
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
        person.infect();
        Assertions.assertEquals(InfectionState.INFECTED, person.getInfectionState());
        for (int i = 0; i <= 10; i++){
            person.update(0);
        }
        Assertions.assertEquals(InfectionState.RECOVERED, person.getInfectionState());
        for (int i = 0; i <= 189; i++){
            person.update(0);
        }
        Assertions.assertEquals(InfectionState.SUSCEPTABLE, person.getInfectionState());
    }
}
