package readonlytest.derivation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PersonDerivationTest {

    private PersonDerivation p;
    private PersonDerivation up;

    @Before
    public void init() {
        p = new PersonDerivationImpl("Giacomo");
        up = new UnmodifiablePersonDerivation("Giacomo");
    }

    @Test
    public void testPerson() {
        assertEquals("Giacomo", p.getName());
        p.setAge(20);
        assertEquals(20, p.getAge());
        p.addFriend(new PersonDerivationImpl("Gianni"));
        p.addFriend(new PersonDerivationImpl("Luigi"));
        assertArrayEquals(new PersonDerivation[] {new PersonDerivationImpl("Gianni"), new PersonDerivationImpl("Luigi")}, p.getFriends().toArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testChangeAgeUnmodifiablePerson() {
        assertEquals("Giacomo", up.getName());
        up.setAge(20);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddFriendUnmodifiablePerson() {
        assertEquals("Giacomo", up.getName());
        up.addFriend(new PersonDerivationImpl("Gianni"));
    }
}
