package readonlytest.derivation;

import java.util.Set;

public interface PersonDerivation {

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
     * Sets the person's age.
     * @throws UnsupportedOperationException if this object does not support changing age.
     * @param age new person's age.
     */
    void setAge(int age);

    /**
     * Returns a set of persons which are friends to this person.
     * @return a set of persons which are friends to this person.
     */
    Set<PersonDerivation> getFriends();

    /**
     * Adds a friend to this person.
     * @throws UnsupportedOperationException if this object does not support adding a friend.
     * @param friend the person to add as a friend.
     */
    void addFriend(PersonDerivation friend);
}
