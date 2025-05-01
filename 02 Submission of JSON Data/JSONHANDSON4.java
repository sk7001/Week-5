package JSON;

import org.json.JSONObject;

public class JSONHANDSON4 {
    public static void main(String[] args) {
        String jsonString = "{\"email\":\"test@example.com\"}";
        JSONObject json = new JSONObject(jsonString);

        if (json.has("email")) {
            String email = json.getString("email");
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Email is valid.");
            } else {
                System.out.println("Email is invalid.");
            }
        } else {
            System.out.println("Email field is missing.");
        }
    }
}