package JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON7 {
    public static void main(String[] args) {
        String jsonString = "[{\"name\":\"John\",\"age\":25},{\"name\":\"Jane\",\"age\":30},{\"name\":\"Doe\",\"age\":22}]";
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject student = jsonArray.getJSONObject(i);
            int age = student.getInt("age");

            if (age > 25) {
                System.out.println(student.toString());
            }
        }
    }
}
