p143  
final 和 private 关键字  
类中所有的 private 方法都是隐式地指定为是 final 的。由于无法取用 private 方法，所以也就无法覆盖它。  
FinalOverridingIllusion.java  
```
// It only looks like you can override 
// a private or private final method.
package reusing;
import static net.mindview.util.Print.*;

class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        print("WithFinals.f()");
    }
    // Also automatically "fianl":
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        print("OverridingPrivate.f()");
    }
    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        print("OverridingPrivate2.f()");
    }
    public void g() {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
}
```
“覆盖”只有在某方法是基类的接口的一部分时才会出现。即，必须能将一个对象向上转型为它的基本类型并调用相同的方法。
如果某方法为 private，它就不是基类的接口的一部分。它仅是一些隐藏于类中的程序代码，只不过是具有相同的名称而已。但
如果在导出类中以相同的名称生成一个 public、protected 或包访问权限方法的话，该方法就不会产生在基类中出现的“仅具有
相同名称”的情况。此时并没有覆盖该方法，仅是生成了一个新的方法。  

