package JSON;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSON3 {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
