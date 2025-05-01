package JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONHANDSON3 {
    public static void main(String[] args) {
        String jsonString = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":22}]";
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            if (user.getInt("age") > 25) {
                System.out.println(user.toString());
            }
        }
    }
}
