package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * Created by nanca on 10/11/2017.
 */

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        printnb(this + " ");
    }

    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task " + id;
    }
}

class DelayedTaskConsumer implements Runnable {

    @Override
    public void run() {

    }
}

public class DelayQueueDemo {

}
