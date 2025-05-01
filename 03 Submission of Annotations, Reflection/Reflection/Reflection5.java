package Reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class Reflection5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add/subtract/multiply): ");
        String methodName = sc.nextLine();
        try {
            Class<?> cls = MathOperations.class;
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method method = cls.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(obj, 10, 5);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
