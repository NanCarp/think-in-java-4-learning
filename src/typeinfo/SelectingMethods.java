package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.mindview.util.Print.*;
/**
 * @ClassName: SelectingMethods.java
 * @Description: Looking for particular methods in a dynamic proxy.
 */

class MethodSelector implements InvocationHandler {
    private Object proxied;
    
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")) {
            print("Proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods {

    public void boring1() {
        print("boring1");
    }

    public void boring2() {
        print("boring2");        
    }

    public void interesting(String arg) {
        print("interesting " + arg);        
    }

    public void boring3() {
        print("boring3");
    }
    
}

public class SelectingMethods {
    /*public static void main(String[] args) {
        SomeMethods proxy = Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
                new Class[] { SomeMethods.class}, h)
    }*/
}
