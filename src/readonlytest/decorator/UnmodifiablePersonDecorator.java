package readonlytest.decorator;

import java.util.Objects;
import java.util.Set;

public class UnmodifiablePersonDecorator implements PersonDecorator {

    private final PersonDecorator person;

    public UnmodifiablePersonDecorator(final PersonDecorator person) {
        this.person = person;
    }

    @Override
    public String getName() {
        return this.person.getName();
    }

    @Override
    public int getAge() {
        return this.person.getAge();
    }

    @Override
    public void setAge(final int age) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<PersonDecorator> getFriends() {
        return this.person.getFriends();
    }

    @Override
    public void addFriend(final PersonDecorator friend) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodifiablePersonDecorator that = (UnmodifiablePersonDecorator) o;
        return Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }

    @Override
    public String toString() {
        return "UnmodifiablePerson{" +
                "person=" + person +
                '}';
    }
}
