package concurrency;

/**
 * @ClassName: BasicTreads.java
 * @Description: The most basic use of the Thread class.
 */
public class BasicTreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
