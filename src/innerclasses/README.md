p196  
Parcel6.java  
```
// Nesting a class within a scope.
package innerclasses;

public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // Can't use it here! Out of scope:
        //! TrackingSlip ts = new TrackingSlip("x");
    }
    public void track() {
        internalTracking(true);
    }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
```
TrackingSlip 类被嵌入在 if 语句的作用域内，这并不是说该类的创造是有条件的，它其实与别的类一起编译过了。然而，
在定义 TrackingSlip 的作用域外，它是不可用的；除此之外，它与普通的类一样。

p198  
Parcel9.java  
```
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.
package innerclasses;

public class Parcel9 {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            public String readLabel() {
                return label;
            }
        };
    }
    
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
```
原文：如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求其引用参数是 final 的，
就像你在 destination() 的参数中看到的那样。如果你忘记了，将会得到一个编译时错误消息。  
注：1.8 有变化，可以不标注 final    
1.8以后，并非不用是final的，而是在编译期间要求值不发生变化。在你的代码中，如果user的值变化了，就会出错。  
编译如下代码：  
```
public class TestFinal 
{
    //这样代码就不能通过编译了
    public void test( User user)
    {
        user = new User();
        user.setName("zhaoyang");
        (new Thread()
            { 
                public void run()
                    {   
                        System.out.println("user.name-->"+user.name);
                    }
            } 
        ).start();  
    }
    public static void main(String[] args) 
    {
        User user=new User();
        user.setId(007);
        user.setName("zhaoyang");
         
        TestFinal testFinal=new TestFinal();
        testFinal.test(user);   
    }
}


class  User
{
    String name=null;
    int id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
     
}

```
你会得到类似下面的错误：  
TestFinal.java:12: 错误: 从内部类引用的本地变量必须是最终变量或实际上的最终变量  
                        System.out.println("user.name-->"+user.name);

p201  
10.7 嵌套类  
如果不需要内部类对象与其外围对象之间有联系，那么可以将内部类声明为 static。这通常成为**嵌套类**。普通的内部类
对象隐式地保存了一个引用，指向创建它的外围类对象。当内部类是 static 时，嵌套类意味着：  
1. 要创建嵌套类的对象，并不需要其外围类的对象。
2. 不能从嵌套类的对象中访问非静态的外围类对象。  

普通内部类的字段和方法，只能放在类的外部层次上，所以普通的内部类不能有 static 数据和 static 字段，也不能包含
嵌套类。嵌套类可以包含所有这些。

Parcel11.java  
```
// Nested classes (static inner classes)
package innerclasses;

public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    
    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
        // Nested classes can contain other static elements:
        public static void f() {}
        static int x = 10;
        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }
    
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    
    public static Contents contents() {
        return new ParcelContents();
    }
    
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}
```
在 main() 中，没有任何 Parcel11 的对象是必需的；而是使用选取 static 成员的普通语法来调用这些方法——这些方法
返回对 Contents 和 Destination 的引用。  
在普通的（非 static）内部类中，通过一个特殊的 this 引用可以链接到其外围类对象。嵌套类没有，这使它类似于一个 
static 方法。  


p204  
为什么需要内部类   
一般说来内部类继承自某个类或实现某个接口，内部类的代码操作创建它的外围类的对象。所以可以认为内部类提供了某种
进入其外围类的窗口。  
如果只是需要一个对接口的引用，为什么不通过外围类实现那个接口呢？如果这能满足需求，就该这么做。内部类实现一个
接口与外围类实现这个接口有什么区别呢?后者不是总能享用到接口带来的方便，有事需要用到接口的实现。内部类最吸引人
的原因是：  
**每个内部类都能独立地继承自一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于
内部类都没有影响。**  
内部类使得多重继承的解决方案变得完整。内部类有效地实现了“多重继承”。也就是说，内部类允许继承多个非接口类型。  


p205  
10.8.1 闭包与回调  











