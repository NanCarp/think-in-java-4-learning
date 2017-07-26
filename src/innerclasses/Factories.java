package innerclasses;

import static net.mindview.util.Print.*;

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {}
    public void method1() {
        print("Implementation1 method1");
    }
    public void method2() {
        print("Implementation1 method2");
    }
}

public class Factories {

}
