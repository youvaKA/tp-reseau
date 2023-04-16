package exercice3V2;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.lang.reflect.Method;

public enum Role {

    SENDER(
        "send",
        new Class[]{String.class}
    ),
    LISTENER(
        "receive",
        null
    );

    Method todo;

    Role(String methodName, Class[] descriptors) {
        try {
            this.todo =  ClientServerChat.class.getMethod(methodName, descriptors);     
        } catch (Exception e) {
            throw new RuntimeException("bruh");
        }
    }
}
