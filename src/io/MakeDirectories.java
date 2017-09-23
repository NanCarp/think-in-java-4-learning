package io;

import java.io.File;

/**
 * Created by NanCarp on 2017/9/23.
 * Demonstrates the use of the File class to
 * create directories and manipulate files.
 * {Args: MakeDirectoriesTest}
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println("");
    }

    private static void fileData(File file) {

    }

    public static void main(String[] args) {
        if (args.length < 1) usage();
        if (args[0].equals("-r")) {
            if(args.length != 3) usage();
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return; // Exit main
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                System.out.println(f + "exists");
                if (del) {
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            } else { // Doesn't exist
                if (!del) {
                    f.mkdirs();
                    System.out.println("create ");
                }
            }
            fileData(f);
        }
    }
}
