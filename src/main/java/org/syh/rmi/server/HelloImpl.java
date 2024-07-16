package org.syh.rmi.server;

import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws Exception {
        super();
    }

    public String sayHello() {
        return "Hello, world!";
    }
}
