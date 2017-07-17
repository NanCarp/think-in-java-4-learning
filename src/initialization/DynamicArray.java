package initialization;

/**
 * Created by nanca on 7/17/2017.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Other.main(new String[]{"fiddle", "de", "dum"});
    }
}

class Other {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
    }
}