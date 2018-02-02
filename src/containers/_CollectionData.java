package containers;

import java.util.ArrayList;

import net.mindview.util.Generator;

/**
 * @ClassName: CollectionData.java
 * @Description: 使用 generator 对象填充数据的 Collection
 */
public class _CollectionData<T> extends ArrayList<T> {
    public _CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }
    // 泛型便利方法
    public static <T> _CollectionData<T> list(Generator<T> gen, int quantity) {
        return new _CollectionData<T>(gen, quantity);
    }
}
