package Reflection;

import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class Reflection10 {
    public static void main(String[] args) {
        Greeting original = new GreetingImpl();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (Object proxyObj, Method method, Object[] methodArgs) -> {
                System.out.println("Calling: " + method.getName());
                return method.invoke(original, methodArgs);
            });
        proxy.sayHello();
    }
}
