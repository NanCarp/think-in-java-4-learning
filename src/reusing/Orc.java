// The protected keyword.
package reusing;
import static net.mindview.util.Print.*;

class Villain {
    private String name;
    protected void set(String m) {
        name = m;
    }
    public Villain(String name) { // 坏人，恶棍；戏剧、小说中的反派角色；顽童；罪犯
        this.name = name;
    }
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain {
    private int orcNumber;
    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber) {
        set(name); // Available because it's protected
        this.orcNumber = orcNumber;
    }
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }
    public static void main(String[] args) {
        Orc orc = new Orc("Limbuger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
}
