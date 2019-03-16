package readonlytest.derivation;

public class UnmodifiablePersonDerivation extends PersonDerivationImpl {

    public UnmodifiablePersonDerivation(final String name) {
        super(name);
    }

    @Override
    public void setAge(final int age) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFriend(final PersonDerivation friend) {
        throw new UnsupportedOperationException();
    }
}
