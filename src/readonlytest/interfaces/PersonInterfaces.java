package readonlytest.interfaces;

public interface PersonInterfaces extends ReadOnlyPerson {

    /**
     * Sets the person's age.
     * @param age new person's age.
     */
    void setAge(int age);

    /**
     * Adds a friend to this person.
     * @param friend the person to add as a friend.
     */
    void addFriend(PersonInterfaces friend);
}