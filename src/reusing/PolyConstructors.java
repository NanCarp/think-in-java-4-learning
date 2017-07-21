// Constructors and polymorphism
package reusing;

import static net.mindview.util.Print.*;

class Glyph { // 象形文字; 纵的沟纹; 竖沟; 浮雕;
    void draw() {
        print("Glyph.draw()");
    }
    
    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
