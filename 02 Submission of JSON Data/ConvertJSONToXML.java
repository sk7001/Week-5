import org.json.JSONObject;
import org.json.XML;
public class ConvertJSONToXML {
   public static void main(String[] args) {
       String jsonString = "{\"name\":\"Alice\",\"age\":30}";
       JSONObject json = new JSONObject(jsonString);
       String xml = XML.toString(json);
       System.out.println(xml);
   }
}
