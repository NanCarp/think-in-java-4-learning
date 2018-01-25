package excecise;

import net.mindview.util.Generator;

import java.util.ArrayList;

/**
 * Created by nanca on 10/28/2017.
 */
public class _CollectionData<T> extends ArrayList<T> {
    public _CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    // A generic convenience method:
    public static <T> _CollectionData<T> list(Generator<T> gen, int quantity) {
        return new _CollectionData<T>(gen, quantity);
    }
}
