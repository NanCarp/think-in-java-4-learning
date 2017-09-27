package io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * Created by nanca on 9/27/2017.
 * Creating a very large file using mapping.
 * {RunByHand}
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128 MB

    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        print("Finished writing");
        for (int i = length/2; i < length/2 + 6; i++) {
            printnb((char) out.get(i));
        }
    }
}
