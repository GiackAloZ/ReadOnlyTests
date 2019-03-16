package readonlytest.interfaces;

import java.util.Set;

public interface ReadOnlyPerson {

    /**
     * Returns the person's name.
     * @return the person's name.
     */
    String getName();

    /**
     * Returns the person's age.
     * @return the person's age.
     */
    int getAge();

    /**
     * Returns a set of persons which are friends to this person.
     * @return a set of persons which are friends to this person.
     */
    Set<ReadOnlyPerson> getFriends();
}
