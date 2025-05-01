package Reflection;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    public static void printKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class Reflection7 {
    public static void main(String[] args) {
        try {
            Class<?> cls = Configuration.class;
            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true);
            field.set(null, "UPDATED_KEY");
            Configuration.printKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
