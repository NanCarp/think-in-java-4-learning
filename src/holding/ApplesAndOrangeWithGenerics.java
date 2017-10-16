package holding;

import java.util.ArrayList;

/**
 * Created by nanca on 10/16/2017.
 */
public class ApplesAndOrangeWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        // 编译期错误：
        // apples.add(new Orange();
        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }
        // 使用 foreach:
        for (Apple c : apples) {
            System.out.println(c.id());
        }
    }
}
