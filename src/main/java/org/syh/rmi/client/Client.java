package org.syh.rmi.client;

import org.syh.rmi.server.Hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            Hello stub = (Hello) registry.lookup("hello");

            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
