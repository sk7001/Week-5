import java.lang.reflect.Field;
class Product {
   public String name = "Phone";
   public double price = 999.99;
}
public class ReflectionToJson {
   public static String toJson(Object obj) throws Exception {
       StringBuilder sb = new StringBuilder();
       sb.append("{");
       Field[] fields = obj.getClass().getDeclaredFields();
       for (int i = 0; i < fields.length; i++) {
           fields[i].setAccessible(true);
           sb.append("\"").append(fields[i].getName()).append("\": ");
           sb.append("\"").append(fields[i].get(obj)).append("\"");
           if (i < fields.length - 1) sb.append(", ");
       }
       sb.append("}");
       return sb.toString();
   }
   public static void main(String[] args) throws Exception {
       Product p = new Product();
       System.out.println(toJson(p));
   }
}
