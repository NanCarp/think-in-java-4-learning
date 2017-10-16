// Adding groups of elements to Collection objects.
// 向 Collection 对象中添加成组元素。
package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        // 这种方法运行起来明显更快，但是不能用来构造 Collection：
        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        // 产生底层表示是数组的 list
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element 修改一个元素 OK
        // list.add(21); // Runtime error because the underlying 运行时错误，因为底层数组不能调整尺寸
                         // array cannot be resized.
    }
}
