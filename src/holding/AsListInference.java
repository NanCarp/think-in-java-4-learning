// Arrays.asList() makes its best guess about type.
// Arrays.asList() 对产生的 List 的类型做出了最理想的假设。
package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        
        // Won't compile:
        // 不会编译
        // List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        // Compiler says:
        // found   : java.util.List<Powder>
        // required: java.util.List<Snow>
        // Collections.addAll() doesn't get confused:
        // Collections.addAll() 不会被迷惑，因为从第一个参数中了解目标类型是 Snow，去掉后同样报错
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        // Give a hint using an explicit type argument specification:
        // 使用显式类型参数说明作提示
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}
