import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
   String name();
}
class UserModel {
   @JsonField(name = "user_name")
   private String username;
   @JsonField(name = "email_address")
   private String email;
   public UserModel(String username, String email) {
       this.username = username;
       this.email = email;
   }
}
public class AnnotationsPracticeJsonField {
   public static String toJson(Object obj) throws IllegalAccessException {
       Class<?> clazz = obj.getClass();
       Map<String, String> jsonMap = new LinkedHashMap<>();
       for (Field field : clazz.getDeclaredFields()) {
           if (field.isAnnotationPresent(JsonField.class)) {
               field.setAccessible(true);
               JsonField jf = field.getAnnotation(JsonField.class);
               jsonMap.put(jf.name(), String.valueOf(field.get(obj)));
           }
       }
       StringBuilder json = new StringBuilder("{");
       for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
           json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
       }
       if (json.length() > 1) json.setLength(json.length() - 1);
       json.append("}");
       return json.toString();
   }
   public static void main(String[] args) throws Exception {
       UserModel user = new UserModel("john_doe", "john@example.com");
       String json = toJson(user);
       System.out.println(json);
   }
}
