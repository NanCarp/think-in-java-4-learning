// Direct field
package reusing;

class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;
}

public class FieldAccess {

}
