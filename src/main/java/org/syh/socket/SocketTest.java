package org.syh.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", Integer.parseInt("8081"));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("GET / HTTP/1.1");
        out.println("Host: localhost:8081");
        out.println("Connection: Close");
        out.println();

        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.sleep(50);
        }

        System.out.println(sb.toString());
        socket.close();

        /*
        HTTP/1.1 200 OK
        Server: nginx/1.23.0
        Date: Sat, 09 Jul 2022 06:54:22 GMT
        Content-Type: text/html
        Content-Length: 398
        Last-Modified: Sat, 09 Jul 2022 06:51:02 GMT
        Connection: close
        ETag: "62c92556-18e"
        Accept-Ranges: bytes

        <!DOCTYPE html>
        <html>
        <head>
            <title>Test</title>
            <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
            <link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
            <link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
        </head>
        <body>
            <p>Just for Test</p>
        </body>
        </html>
        */
    }
}
