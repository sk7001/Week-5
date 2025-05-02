import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
   int value();
}
class User {
   @MaxLength(10)
   private String username;
   public User(String username) {
       this.username = username;
       validate();
   }
   private void validate() {
       try {
           for (Field field : this.getClass().getDeclaredFields()) {
               if (field.isAnnotationPresent(MaxLength.class)) {
                   field.setAccessible(true);
                   String val = (String) field.get(this);
                   int max = field.getAnnotation(MaxLength.class).value();
                   if (val.length() > max) {
                       throw new IllegalArgumentException(field.getName() + " exceeds max length of " + max);
                   }
               }
           }
       } catch (IllegalAccessException e) {
           throw new RuntimeException(e);
       }
   }
}
public class AnnotationsPracticeMaxLength {
   public static void main(String[] args) {
       try {
           new User("shortname");
           new User("verylongusername");
       } catch (IllegalArgumentException e) {
           System.out.println("Validation error: " + e.getMessage());
       }
   }
}
