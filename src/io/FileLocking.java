package io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by nanca on 9/27/2017.
 */
public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
