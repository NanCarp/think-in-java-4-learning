package concurrency;

/**
 * Created by nanca on 10/9/2017.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumbber() {
        return serialNumber++; // Not thread-safe
    }
}
