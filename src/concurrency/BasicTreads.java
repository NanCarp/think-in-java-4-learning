package concurrency;

/**
 * @ClassName: BasicTreads.java
 * @Description: Thread 类的最基本的使用方式.
 */
public class BasicTreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
