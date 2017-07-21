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

p156
缺陷：“覆盖”私有方法  
PrivateOverride.java  
```
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
```
期望输出 public f()，但是由于 private 方法被自动认为是 final 方法，而且对于导出类是屏蔽的。因此，在这种情况下，
Derived 类中的 f() 方法就是一个全新的方法；既然基类中的 f() 方法在子类中不可见，因此甚至也不能被重载。  
结论：只有非 private 方法才可以被覆盖；在导出类中，对于基类的 private 方法，最好采用不同的名字。  

缺陷：域与静态方法  
如果某个方法是静态的，它的行为就不具有多态性：  
StaticPolymorphysim.java  
```
// Static methods are not polymorphic.
package reusing;

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }
    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}

```
静态方法是与类，而并非是与单个的对象相关联的。   
  
p162  
构造器内部的多态方法的行为   
如果在一个构造器的内部调用正在构造的对象的某个动态绑定方法，会发生什么情况？  
在一般的方法内部，动态绑定的调用是在运行时才决定的，因为对象无法知道它是属于方法所在的那个类，还是属于那个类
的导出类。  
如果要调用构造器内部的一个动态绑定方法，就要用到那个方法的被覆盖后的定义。然而，这个调用的效果可能相当难于预料，
因为被覆盖的方法在对象被完全构造之前就会被调用。这可能会造成一些难于发现的隐藏错误。  
PolyConstructors.java  
```
// Static methods are not polymorphic.
package reusing;

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }
    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
```
Glyph.draw() 方法设计为将要被覆盖，这种覆盖是在 RoundGlyph 中发生的。但是 Glyph 构造器会调用这个方法，结果
导致了对 RoundGlyph.draw() 方法的调用，但是 radius 不是默认初始值 1，而是 0。  
初始化的实际过程：  
1. 在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零。
2. 调用基类构造器。这个步骤会不断地反复递归，首先是构造这种层次结构的根，然后是下一层导出类，直到最底层的
导出类。此时，调用被覆盖后的 draw() 方法（要在调用 RoundGlyph 构造器之前调用），由于步骤 1 的缘故，此时 
radius 的值为 0。
3. 按照声明的顺序调用成员的初始化方法。
4. 调用导出类的构造器主体。  

编写构造器一条有效的准则：“用尽可能简单的方法是对象进入正常状态；如果可以，避免调用其他方法”。在构造器内
唯一能够安全调用的那些方法是基类中的 final 方法（也适用于 private 方法，默认 final）。这些方法不能被覆盖，
因此也就不会出现上述问题。  
  
P165  
继承与组合，组合不会强制我们的程序设计进入继承的层次结构中。而且，组合更加灵活，因为它可以动态选择类型（因此
也就选择了行为）；相反，继承在编译时就需要知道确切类型。  
Transmogrify.java  
```
package reusing;

import static net.mindview.util.Print.*;

class Actor {
    public void act() {}
}

class HappyActor extends Actor {
    public void act() {
        print("HappyActor");
    }
}

class SadActor extends Actor {
    public void act() {
        print("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();
    public void change() {
        actor = new SadActor();
    }
    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify { // 使变形，使完全改变性质;
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
```
在这里，Stage 对象一个对 Actor 的引用，而 Actor 被初始化为 HappyActor 对象。这意味着 performPlay() 会
产生某种特殊行为。使用 SadActor 对象的引用替代 HappyActor，performPlay() 产生行为也随之改变。这样，我们
在运行期间获得了动态灵活性（这也称作**状态模式**，参阅 《Thinking in Patterns(with Java)》）。与此相反，
我们不能在运行期间继承不同的对象，因为它要求在编译期间完全确定下来。   
通用准则：“用继承表达行为间的差异，并用字段表达状态上的变化”。上述例子：通过继承得到两个不同的类，用于
表达 act() 方法的差异；而 Stage 通过运用组合使自己的状态发生变化，在这种情况下，这种状态的改变也就产生了
行为的改变。  















