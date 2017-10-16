package holding;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by nanca on 10/16/2017.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c.add(i); // 自动装箱
        }
        for (Integer i : c) {
            System.out.println(i + ", ");
        }
    }
}
