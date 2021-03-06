package containers;

/**
 * Created by nanca on 9/17/2017.
 */
public class Individual_c implements Comparable<Individual_c>{
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual_c(String name) {
        this.name = name;
    }

    public Individual_c() {}

    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    public boolean equals(Object o) {
        return o instanceof Individual_c &&
                id == ((Individual_c)o).id;
    }

    public int hashCode() {
        int result = 17;
        if (name != null) {
            return 37 * result + name.hashCode();
        }
        result = 37 * result + (int)id;
        return result;
    }

    @Override
    public int compareTo(Individual_c arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
