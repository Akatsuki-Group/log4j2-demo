package org.example.rmi1.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

public class RmiRegistry {

    private final static Integer rmiPort = 1099;

    public static void main(String[] args) throws RemoteException, InterruptedException {
        // 创建一个 Registry
        LocateRegistry.createRegistry(rmiPort);
        System.out.println("RMI server started on: 0.0.0.0:" + rmiPort);

        // 阻塞主线程，避免程序退出
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
