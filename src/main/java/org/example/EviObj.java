package org.example;

import java.io.IOException;

public class EviObj {
    static {
        System.out.println("在这行代码中执行的");
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
