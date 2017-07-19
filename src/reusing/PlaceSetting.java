package reusing;
// Combining composition & inheritance
import static net.mindview.util.Print.*;

class Plate {
    Plate(int i) {
        print("Plate Constructor");
    }
}

class DinnerPlate extends Plate {

    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate Constructor");
    }
        
}

class Utensil { // 器皿; 器具，用具; 家庭厨房用具;
    Utensil(int i) {
        print("Utensil Constructor");
    }
}

class Spoon extends Utensil {

    Spoon(int i) {
        super(i);
        print("Spoon Constructor");
    }
    
}

class Fork extends Utensil {

    Fork(int i) {
        super(i);
        print("Fork Constructor");
    }
    
}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        print("Fork Constructor");
    }
    
}

// A cultural way of doing something:
class Custom {
    Custom(int i) {
        print("Custom Constructor");
    }
}

public class PlaceSetting extends Custom {
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        print("PlaceSetting Constructor");
    }
    
    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }

}
