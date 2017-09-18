package containers;

/**
 * Created by nanca on 9/17/2017.
 * Framework for performing timed tests of containers.
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    // Override this method for different tests.
    // Returns actual number of repetition of test.
    abstract int test(C container, TestParam tp);
}
