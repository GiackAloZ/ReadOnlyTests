package readonlytest.decorator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonDecoratorTest {

    private PersonDecorator p;
    private PersonDecorator up;

    @Before
    public void init() {
        p = new PersonDecoratorImpl("Giacomo");
        up = new UnmodifiablePersonDecorator(p);
    }

    @Test
    public void testPerson() {
        assertEquals("Giacomo", p.getName());
        p.setAge(20);
        assertEquals(20, p.getAge());
        p.addFriend(new PersonDecoratorImpl("Gianni"));
        p.addFriend(new PersonDecoratorImpl("Luigi"));
        assertArrayEquals(new PersonDecorator[] {new PersonDecoratorImpl("Gianni"), new PersonDecoratorImpl("Luigi")}, p.getFriends().toArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testChangeAgeUnmodifiablePerson() {
        assertEquals("Giacomo", up.getName());
        up.setAge(20);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddFriendUnmodifiablePerson() {
        assertEquals("Giacomo", up.getName());
        up.addFriend(new PersonDecoratorImpl("Gianni"));
    }
}