package at.htlleonding.pansim;

public class TestPerson extends Person {
    @Override
    public boolean participateInEvent(Event e) {
        System.out.println("TestPerson: participateInEvent" + e.toString());
        return super.participateInEvent(e);
    }
}
