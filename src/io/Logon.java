package io;

import static net.mindview.util.Print.print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * @ClassName: Logon.java
 * @Description: Demonstrate the "transient" keyword.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }
    
    public String toString() {
        return "username: " + username + "password" + password;
    }
    
    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        print("logon a = " + a);
        
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); // Delay
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Logon.out"));
        print("Recovering object at " + new Date());
        a = (Logon)in.readObject();
        print("logon a = " + a);
        
    }

}
