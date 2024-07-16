package org.syh.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Hello obj = new HelloImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("hello", obj);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
