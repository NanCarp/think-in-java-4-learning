package concurrency;

/**
 * Created by nanca on 10/9/2017.
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue; // Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
