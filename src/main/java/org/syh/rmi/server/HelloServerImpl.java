package org.syh.rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServerImpl extends UnicastRemoteObject implements HelloServer {
    public HelloServerImpl() throws RemoteException {}

    public String sayHello() {
        return "Hello";
    }

    public static void main(String args[]) {
        try {
            HelloServer obj = new HelloServerImpl();
            Naming.rebind("HelloServer", obj);
        } catch (Exception e)
        {
            System.out.println("HelloServer err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
