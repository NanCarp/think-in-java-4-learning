// Upcasting to a Queue from a LinkedList
package holding;

import java.util.Queue;

public class QueueDemo {
    public static void printQ(Queue queue) {
        while(queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
