package at.htlleonding.pansim;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventUT {

    @Test
    void testJoinShallReturnTrueGivenAPerson() {
        Event event = new Event(EventType.TEST);

        Person uninfected = new Person();
        Person infected = new Person();
        infected.infect();

        event.join(uninfected, 100);
        event.join(infected, 100);

        event.update(1);
        Assertions.assertEquals(InfectionState.INFECTED, uninfected.getInfectionState());
    }
}