package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by NanCarp on 2017/9/23.
 * Testing for end of file while reading a byte at a time.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("TestEOF.java")
                )
        );
        while (in.available() != 0) {
            System.out.println((char)in.readByte());
        }
    }
}
