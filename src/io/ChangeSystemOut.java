package io;

import java.io.PrintWriter;

/**
 * Created by NanCarp on 2017/9/24.
 * Turn System.out into a PrintWriter.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");

    }
}
