package org.syh.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloServer extends Remote {
    String sayHello() throws RemoteException;
}
