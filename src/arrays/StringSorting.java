package arrays;
import static net.mindview.util.Print.*;

import java.util.Arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;
/**
 * @ClassName: StringSorting.java
 * @Description: Sorting an array of Strings.
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20],
                new RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        print("Reverse sort: " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sort: " + Arrays.toString(sa));
    }
}
