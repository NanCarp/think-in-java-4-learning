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
Parcel11.java  

p204  
为什么需要内部类   

p205  
10.8.1 闭包与回调  