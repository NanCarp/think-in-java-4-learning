package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExceptionThread.java
 * @Description: {ThrowsException}
 */
public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }

}
