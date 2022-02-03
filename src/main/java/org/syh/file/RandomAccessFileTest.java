package org.syh.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        File dir = new File("dir");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File("dir", "file");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");

        // write method will change the file pointer
        randomAccessFile.writeBoolean(false); // 1 byte
        randomAccessFile.writeInt(1);         // 4 byte

        randomAccessFile.seek(0);
        // while read method won't change the file pointer
        System.out.println(randomAccessFile.readBoolean());
        System.out.println(randomAccessFile.readBoolean());
        randomAccessFile.seek(1);
        System.out.println(randomAccessFile.readInt());
        System.out.println(randomAccessFile.length());
    }
}
