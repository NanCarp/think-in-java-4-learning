package reusing;

import static net.mindview.util.Print.print;

/**
 * Created by nanca on 7/18/2017.
 * Inheritance syntax & properties.
 */

class Cleanser { // 清洁器，清洁剂
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() { // 稀释，冲淡
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();x.apply();x.scrub();
        print(x);
    }
}

public class Detergent extends Cleanser { // 清洁器，清洁剂
    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
}
