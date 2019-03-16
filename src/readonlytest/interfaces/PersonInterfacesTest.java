package readonlytest.interfaces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonInterfacesTest {

    private PersonInterfaces p;
    private ReadOnlyPerson rp;

    @Before
    public void init() {
        p = new PersonInterfacesImpl("Giacomo");
        rp = new PersonInterfacesImpl("Giacomo");
    }

    @Test
    public void testPerson() {
        assertEquals("Giacomo", p.getName());
        p.setAge(20);
        assertEquals(20, p.getAge());
        p.addFriend(new PersonInterfacesImpl("Gianni"));
        p.addFriend(new PersonInterfacesImpl("Luigi"));
        assertArrayEquals(new ReadOnlyPerson[] {new PersonInterfacesImpl("Gianni"), new PersonInterfacesImpl("Luigi")}, p.getFriends().toArray());
    }
}
