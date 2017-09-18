package containers;

import java.util.*;

/**
 * Created by nanca on 9/18/2017.
 * Using the Collections.synchronized methods.
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(
                new ArrayList<String>()
        );
        List<String> list = Collections.synchronizedList(
                new ArrayList<String>()
        );
        Set<String> s = Collections.synchronizedSet(
                new HashSet<String>()
        );
        // TODO
    }
}
