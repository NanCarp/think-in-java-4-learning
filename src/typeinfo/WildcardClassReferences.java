package typeinfo;

/**
 * Created by nanca on 8/15/2017.
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
