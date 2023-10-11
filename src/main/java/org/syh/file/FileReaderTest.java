package org.syh.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReaderTest {
    public static String projectPath = System.getProperty("user.dir");
    public static String resourcePath = projectPath + "/src/main/resources";

    public static void main(String[] args) throws Exception {
        readByReader("file-contains-newline-real");
        readByReader("file-contains-newline-fake");
        readByInputStream("file-contains-newline-real");
        readByInputStream("file-contains-newline-fake");
    }

    public static void readByReader(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath + "/" + fileName));
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = bufferedReader.read()) != -1) {
            sb.append((char) (ch));
        }
        System.out.println(sb.length());
        System.out.println(sb);
        System.out.println("---------------------------");
    }

    public static void readByInputStream(String fileName) throws Exception {
        FileInputStream inputStream = new FileInputStream(resourcePath + "/" + fileName);
        List<Byte> content = new ArrayList<>();
        byte singleByte;
        while ((singleByte = (byte) inputStream.read()) != -1) {
            content.add(singleByte);
        }
        System.out.println(content.size());
        System.out.println(content);

        byte[] contentBytes = new byte[content.size()];
        for (int i = 0; i < contentBytes.length; i++) {
            contentBytes[i] = content.get(i);
        }
        String contentStr = new String(contentBytes, StandardCharsets.UTF_8);
        System.out.println(contentStr);
        System.out.println("---------------------------");
    }
}
