package Reflection;
public class Student {
   public Student() {
       System.out.println("Student object created!");
   }
}
public class ReflectionDynamicObjectCreation {
   public static void main(String[] args) {
       try {
           Class<?> cls = Class.forName("Reflection.Student");
           Object obj = cls.getDeclaredConstructor().newInstance();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
