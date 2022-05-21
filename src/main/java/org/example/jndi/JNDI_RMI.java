package org.example.jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDI_RMI {
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        Object obj = context.lookup("rmi://localhost:1099/Exploit");
        System.out.println("obj = " + obj);
    }
}
