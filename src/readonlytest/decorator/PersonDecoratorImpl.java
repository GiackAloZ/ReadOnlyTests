package readonlytest.decorator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonDecoratorImpl implements PersonDecorator {

    private final String name;
    private int age;
    private final Set<PersonDecorator> friends;

    public PersonDecoratorImpl(final String name) {
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
    public Set<PersonDecorator> getFriends() {
        return Collections.unmodifiableSet(this.friends);
    }

    @Override
    public void addFriend(final PersonDecorator friend) {
        this.friends.add(friend);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDecoratorImpl person = (PersonDecoratorImpl) o;
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
