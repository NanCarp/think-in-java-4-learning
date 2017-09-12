package arrays;
import static net.mindview.util.Print.*;

import java.util.Arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
/**
 * @ClassName: ArraySearching.java
 * @Description: Using Arrays.binarySearch().
 */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                print("Location of " + r + " is " + location +
                        ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }
}
