package holding;

import java.util.ArrayList;

/**
 * Created by nanca on 10/14/2017.
 * 简单容器示例 (产生编译警告).
 * {抛出异常}
 */

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() {
        return id;
    }
}

class Orange {}

public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        // 没有阻止添加一个 Orange 到 apples 中：
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple)apples.get(i)).id();
            // Orange 只有在运行时才能检测到
        }
    }
}
