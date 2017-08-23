package typeinfo;

import static net.mindview.util.Print.print;

import typeinfo.interfacea.A;

/**
 * @ClassName: AnonymouseA.java
 * @Description: Anonymous inner classes can't hide from reflection
 */
public class AnonymouseA {
    public static A makeA() {
        return new A() {
            public void f() {
                print("public C.f()");
            }
            public void g() {
                print("public C.g()");
            }
            void u() {
                print("package C.u()");
            }
            protected void v() {
                print("protected C.v()");
            }
            private void w() {
                print("private C.w()");
            }
        };
    }

}
