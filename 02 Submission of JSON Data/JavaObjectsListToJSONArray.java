import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class JavaObjectsListToJSONArray {
   static class Student {
       String name;
       int age;
       Student(String name, int age) {
           this.name = name;
           this.age = age;
       }
   }
   public static void main(String[] args) {
       List<Student> students = new ArrayList<>();
       students.add(new Student("John", 21));
       students.add(new Student("Jane", 22));
       JSONArray jsonArray = new JSONArray();
       for (Student student : students) {
           JSONObject jsonStudent = new JSONObject();
           jsonStudent.put("name", student.name);
           jsonStudent.put("age", student.age);
           jsonArray.put(jsonStudent);
       }
       System.out.println(jsonArray.toString());
   }
}
