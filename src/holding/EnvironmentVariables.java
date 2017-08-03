package holding;

import java.util.Map;

/**
 * Created by nanca on 8/3/2017.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
