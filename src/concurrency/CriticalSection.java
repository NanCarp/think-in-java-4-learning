package concurrency;

import jdk.internal.dynalink.support.RuntimeContextLinkRequestImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nanca on 10/9/2017.
 * Synchronizing blocks instead of entire methods. Also
 * demonstrates protection of a non-thread-safe class
 * with a thread-safe one.
 */

class Pair { // Not thread-safe
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: "+Pair.this);
        }
    }

    // Arbitrary invariant -- both variables must be equal:
    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

// Protect a Pair inside a thread safe class:
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        // Makde a copy to keep the original safe:
        return new Pair(p.getX(), p.getY());
    }

    // Assume this is a time consuming operation
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {

        }
    }
    public abstract void increment();
}

// Synchronize the entire method:
/*class PairManager1 extends PairManager {

}*/


public class CriticalSection {
}
