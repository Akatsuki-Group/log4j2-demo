package org.example.rmi1.server;

import org.example.rmi1.HelloService;

import java.rmi.RemoteException;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) throws RemoteException {
        System.out.println("hello " + name);
    }
}
