import org.json.JSONArray;
import org.json.JSONObject;
public class CreateStudentJSONObject {
   public static void main(String[] args) {
       JSONObject student = new JSONObject();
       student.put("name", "John Doe");
       student.put("age", 21);
       JSONArray subjects = new JSONArray();
       subjects.put("Math");
       subjects.put("Science");
       subjects.put("English");
       student.put("subjects", subjects);
       System.out.println(student.toString());
   }
}
