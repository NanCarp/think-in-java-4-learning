package concurrency;

import static net.mindview.util.Print.*;
/**
 * @ClassName: ThreadVariations.java
 * @Description: Creating threads with inner classes.
 */
// Using a named inner class:
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }
        
        public void run() {
            try {
                while(true) {
                    print(this);
                    if(--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                print("interrupted");
            }
        }
        
        public String toString() {
            return getName() + ": " + countDown;
        }
    }
    
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

// Using an anonymous inner class:
class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    
    
}

public class ThreadVariations {

}
