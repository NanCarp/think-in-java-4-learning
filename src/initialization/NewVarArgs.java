package initialization;

/**
 * Created by nanca on 7/17/2017.
 * Using array syntax to create variable argument lists.
 */
public class NewVarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Can take individual elements
        printArray(new Object[] {
                new Integer(47), new Float(3.14), new Double(11.11)
        });
        printArray(new Object[] {"one", "two", "three"});
        printArray(new Object[] {new A(), new A(), new A()});
        // Or an array
        printArray((Object[]) new Integer[]{1,2,3,4});
        printArray(); // Empty list is OK
    }
}
