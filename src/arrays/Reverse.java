package arrays;

import static net.mindview.util.Print.print;

import java.util.Arrays;
import java.util.Collections;

import net.mindview.util.Generated;

/**
 * @ClassName: Reverse.java
 * @Description: The Collections.reverseOrder() Comparator
 */
public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
