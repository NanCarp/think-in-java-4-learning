package polymorphism;

import static net.mindview.util.Print.print;

/**
 * Created by NanCarp on 2017/7/21.
 * Cleanup and inheritance.
 */

class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        print("Creating Characteristic " + s);
    }

    protected void dispose() {
        print("disposing Characteristic " + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        print("Creating Description " + s);
    }

    protected void dispose() {
        print("disposing Description " + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature");

    LivingCreature() {
        print("LivingCreature()");
    }

    protected void dispose() {
        print("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("has heart");
    private Description t = new Description("Animal not Vegetable");

    Animal() {
        print("Animal()");
    }

    protected void dispose() {
        print("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal{ // 两栖动物
    private Characteristic p = new Characteristic("can live in water");
    private Description t = new Description("Both water and land");

    Amphibian() {
        print("Amphibian()");
    }

    protected void dispose() {
        print("Amphibian dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Frog extends Amphibian{ // 两栖动物
    private Characteristic p = new Characteristic("Croaks"); // 呱呱地叫
    private Description t = new Description("Eats Bugs");

    Frog() {
        print("Frog()");
    }

    protected void dispose() {
        print("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        print("Bye!");
        frog.dispose();
    }
}
