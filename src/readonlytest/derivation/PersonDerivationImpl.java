package readonlytest.derivation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonDerivationImpl implements PersonDerivation {

    private final String name;
    private int age;
    private final Set<PersonDerivation> friends;

    public PersonDerivationImpl(final String name) {
        this.name = name;
        this.age = 0;
        this.friends = new HashSet<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public Set<PersonDerivation> getFriends() {
        return Collections.unmodifiableSet(this.friends);
    }

    @Override
    public void addFriend(final PersonDerivation friend) {
        this.friends.add(friend);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDerivationImpl person = (PersonDerivationImpl) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(friends, person.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, friends);
    }

    @Override
    public String toString() {
        return "PersonImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                '}';
    }
}
