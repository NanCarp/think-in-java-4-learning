package initialization;

/**
 * Created by nanca on 7/12/2017.
 */
class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }
    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
        // Normally, you'll not also do this:
        // super.finalize(); // Call the base-class version
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization
        System.gc();
    }
}
