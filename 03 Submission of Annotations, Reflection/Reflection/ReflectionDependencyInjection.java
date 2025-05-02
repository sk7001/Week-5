import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}
class Engine {
   public void start() {
       System.out.println("Engine started");
   }
}
class Car {
   @Inject
   Engine engine;
}
public class ReflectionDependencyInjection {
   public static void main(String[] args) throws Exception {
       Car car = new Car();
       for (Field field : car.getClass().getDeclaredFields()) {
           if (field.isAnnotationPresent(Inject.class)) {
               field.setAccessible(true);
               field.set(car, field.getType().getDeclaredConstructor().newInstance());
           }
       }
       car.engine.start();
   }
}
