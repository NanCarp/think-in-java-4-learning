package holding;

import typeinfo.pets.Pet;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by nanca on 8/3/2017.
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
}
