// Simple demonstration of HashMap.
package holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            // 产生 0 到 20 间的数
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
        System.out.println();
        Object[] keySet = m.keySet().toArray();
        for (int i = 0; i < keySet.length; i++) {
            System.out.print(keySet[i] + "=" + m.get(keySet[i]) + " ");
        }
    }
}
