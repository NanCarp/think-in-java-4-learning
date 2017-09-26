package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by nanca on 9/26/2017.
 * Using transferTo() between channels
 * {Args: TransferTo.java TransferTo.txt}
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // Or:
        // out.transferFrom(in, o, in.size());
    }
}
