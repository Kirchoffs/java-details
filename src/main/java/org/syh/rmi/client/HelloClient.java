package org.syh.rmi.client;

import org.syh.rmi.server.HelloServer;
import java.rmi.Naming;

public class HelloClient {
    public static void main(String arg[]) {
        new HelloClient().run();
    }

    public void run() {
        try {
            HelloServer obj = (HelloServer) Naming.lookup("rmi://127.0.0.1/HelloServer");
            System.out.println(obj.sayHello());
        } catch (Exception e) {
            System.out.println("HelloServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
