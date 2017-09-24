package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by NanCarp on 2017/9/24.
 * Utility for reading files in binary form.
 */
public class _BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile)
        );
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }

    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
