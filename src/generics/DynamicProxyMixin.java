package generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;
    //public MixinProxy()
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        return null;
    }
    
}

public class DynamicProxyMixin {

}
