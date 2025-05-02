import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class UserListToJSONArray {
   static class User {
       String name;
       int age;
       User(String name, int age) {
           this.name = name;
           this.age = age;
       }
   }
   public static void main(String[] args) {
       List<User> users = new ArrayList<>();
       users.add(new User("Alice", 30));
       users.add(new User("Bob", 22));
       JSONArray jsonArray = new JSONArray();
       for (User user : users) {
           JSONObject obj = new JSONObject();
           obj.put("name", user.name);
           obj.put("age", user.age);
           jsonArray.put(obj);
       }
       System.out.println(jsonArray.toString());
   }
}
