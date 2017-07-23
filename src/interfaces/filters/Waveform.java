package interfaces.filters;

/**
 * Created by nanca on 7/23/2017.
 */

public class Waveform {
    private static long counter;
    private final long id  = counter++;
    public String toString() {
        return "Waveform " + id;
    }
}
