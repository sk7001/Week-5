package JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class JSONHANDSON8 {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:5000/db", "admin", "admin");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users");

        JSONArray jsonArray = new JSONArray();
        while (rs.next()) {
            JSONObject obj = new JSONObject();
            obj.put("id", rs.getInt("id"));
            obj.put("name", rs.getString("name"));
            obj.put("age", rs.getInt("age"));
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString());

        rs.close();
        stmt.close();
        conn.close();
    }
}
