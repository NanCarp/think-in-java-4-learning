// Wind objects are instruments
// because they have the same interface:
package polymorphism.music;

public class Wind extends Instrument {
    // Redefine interface method:
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
