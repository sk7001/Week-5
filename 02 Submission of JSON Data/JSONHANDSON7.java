package JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONHANDSON7 {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("contacts.csv")));
        String[] lines = content.split("\n");
        String[] headers = lines[0].split(",");
        JSONArray jsonArray = new JSONArray();

        for (int i = 1; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            JSONObject obj = new JSONObject();
            for (int j = 0; j < headers.length; j++) {
                obj.put(headers[j], data[j]);
            }
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString());
    }
}
