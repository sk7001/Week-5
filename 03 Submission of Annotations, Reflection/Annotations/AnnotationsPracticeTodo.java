import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
   String task();
   String assignedTo();
   String priority() default "MEDIUM";
}
class Project {
   @Todo(task = "Implement login", assignedTo = "Alice", priority = "HIGH")
   public void login() {}
   @Todo(task = "Add logging", assignedTo = "Bob")
   public void auditLog() {}
   public void dashboard() {}
}
public class AnnotationsPracticeTodo {
   public static void main(String[] args) {
       Project p = new Project();
       for (Method m : p.getClass().getDeclaredMethods()) {
           if (m.isAnnotationPresent(Todo.class)) {
               Todo todo = m.getAnnotation(Todo.class);
               System.out.println("Task: " + todo.task() +
                                  ", Assigned To: " + todo.assignedTo() +
                                  ", Priority: " + todo.priority());
           }
       }
   }
}
