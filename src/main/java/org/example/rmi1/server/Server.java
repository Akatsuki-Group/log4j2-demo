package org.example.rmi1.server;

import org.example.rmi1.HelloService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws Exception {
        // 实例化要暴露的对象
        HelloService helloService = new HelloServiceImpl();

        // 将对象暴露出去，RMI 底层会创建该对象的一个代理对象，并监听一个端口用于处理来自客户端的请求
        HelloService skeleton = (HelloService) UnicastRemoteObject.exportObject(helloService, 1100);

        /*================= 注册方式一开始 ====================*/
        // 获取 Registry
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // 将这个对象注册到 Registry 中，第一个参数就是这个对象在 Registry 中的名称，客户端需要使用这个名称才能获取到这个对象
        registry.bind("helloService", skeleton);
        /*================= 注册方式一结束 ====================*/

        /*================= 注册方式二开始 ====================*/
//        Naming.bind("rmi://localhost:1099/helloService", skeleton);
        /*================= 注册方式二结束 ====================*/
        System.out.println("export helloService");
    }
}
