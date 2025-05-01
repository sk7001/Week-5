package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class QA {
    @BugReport(description = "Null pointer on login")
    @BugReport(description = "Crash on empty username")
    public void testLoginFeature() {
        System.out.println("Testing login feature...");
    }
}

public class AnnotationsExercise5 {
    public static void main(String[] args) throws Exception {
        Method method = QA.class.getMethod("testLoginFeature");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports reports = method.getAnnotation(BugReports.class);
            for (BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }
}
