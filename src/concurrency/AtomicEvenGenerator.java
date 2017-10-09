package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nanca on 10/9/2017.
 * Atomic classes are occasionally useful in regular code.
 * {RunByHand}
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
