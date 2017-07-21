package reusing;
import static net.mindview.util.Print.*;
/**
 * Created by NanCarp on 2017/7/21.
 * Trying to override a private method.
 */
public class PrivateOverride {
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        print("public f()");
    }
}