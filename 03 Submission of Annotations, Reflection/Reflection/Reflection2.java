package Reflection;

import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class Reflection2 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original Age: " + ageField.getInt(p));

        ageField.setInt(p, 30);
        System.out.println("Modified Age: " + ageField.getInt(p));
    }
}
