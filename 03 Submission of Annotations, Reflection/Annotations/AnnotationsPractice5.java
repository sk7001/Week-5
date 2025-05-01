package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted.");
    }

    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("Profile viewed.");
    }
}

public class AnnotationsPractice5 {
    public static void main(String[] args) throws Exception {
        String currentRole = "USER";
        SecureService service = new SecureService();

        for (Method method : service.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentRole)) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied to " + method.getName() + " for role: " + currentRole);
                }
            }
        }
    }
}
