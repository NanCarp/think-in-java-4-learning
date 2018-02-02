// The "Adapter Method" idiom allows you to use foreach
// with additional kinds of Iterables.
// 惯用法“适配器方法”允许你通过额外的 Iterables 来使用 foreach
package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }
    public Iterable<T> reversed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    public boolean hasNext() {
                        return current > -1;
                    }
                    public T next() {
                        return get(current--);
                    }
                    public void remove() { // Not implementd
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}


public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
            Arrays.asList("To be or not to be".split(" ")));
        // Grabs the ordinary iterator via iterator():
        // 得到磨人的迭代器
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Hand it the Iterable of your choice
        // 使用你选择的 Iterable 来处理 
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }
    }
}
