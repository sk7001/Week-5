package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Worker {
    @LogExecutionTime
    public void heavyTask() {
        for (int i = 0; i < 1_000_000; i++);
    }

    @LogExecutionTime
    public void lightTask() {
        for (int i = 0; i < 100_000; i++);
    }
}

public class AnnotationsPractice3 {
    public static void main(String[] args) throws Exception {
        Worker w = new Worker();
        for (Method m : w.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(w);
                long end = System.nanoTime();
                System.out.println(m.getName() + " took " + (end - start) + " ns");
            }
        }
    }
}
