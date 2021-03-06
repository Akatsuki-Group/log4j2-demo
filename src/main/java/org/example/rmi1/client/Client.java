package org.example.rmi1.client;

import org.example.rmi1.HelloService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws Exception {

        /*================= 获取方式一开始 ====================*/
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        HelloService stub = (HelloService) registry.lookup("helloService");
        /*================= 获取方式一结束 ====================*/

        /*================= 获取方式二开始 ====================*/
//        HelloService stub = (HelloService) Naming.lookup("rmi://localhost:1099/helloService");
        /*================= 获取方式二结束 ====================*/

        stub.sayHello("守法市民小杜");
    }
}
