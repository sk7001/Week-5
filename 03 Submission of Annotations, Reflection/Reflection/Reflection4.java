package Reflection;

public class Reflection4 {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Reflection.Student");
            Object obj = cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
