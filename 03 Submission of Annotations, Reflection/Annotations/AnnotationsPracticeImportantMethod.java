import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
   String level() default "HIGH";
}
class Feature {
   @ImportantMethod
   public void login() {
       System.out.println("Login feature");
   }
   @ImportantMethod(level = "MEDIUM")
   public void logout() {
       System.out.println("Logout feature");
   }
   public void view() {
       System.out.println("View feature");
   }
}
public class AnnotationsPracticeImportantMethod {
   public static void main(String[] args) {
       Feature f = new Feature();
       for (Method m : f.getClass().getDeclaredMethods()) {
           if (m.isAnnotationPresent(ImportantMethod.class)) {
               ImportantMethod imp = m.getAnnotation(ImportantMethod.class);
               System.out.println(m.getName() + " is important with level: " + imp.level());
           }
       }
   }
}
