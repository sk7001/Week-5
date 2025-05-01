package JSON;

import org.json.JSONObject;

public class JSON5 {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\"}";
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            if (jsonObject.has("name")) {
                System.out.println("Valid JSON structure: Name exists");
            } else {
                System.out.println("Invalid JSON structure: Name is missing");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
