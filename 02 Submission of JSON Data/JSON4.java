package JSON;

import org.json.JSONObject;

public class JSON4 {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "John");
        json1.put("age", 25);

        JSONObject json2 = new JSONObject();
        json2.put("email", "john@example.com");
        json2.put("address", "123 Main St");

        json1.put("contact", json2);

        System.out.println(json1.toString());
    }
}
