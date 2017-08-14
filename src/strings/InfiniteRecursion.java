package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanca on 8/14/2017.
 * Accidental recursion.
 * {RunByHand}
 */
public class InfiniteRecursion {
    public String toString() {
        return "InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
