package org.example.rmi1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    void sayHello(String name) throws RemoteException;
}
