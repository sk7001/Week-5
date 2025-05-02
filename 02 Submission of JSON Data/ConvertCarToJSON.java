import org.json.JSONObject;
public class ConvertCarToJSON {
   static class Car {
       String make;
       String model;
       int year;
       Car(String make, String model, int year) {
           this.make = make;
           this.model = model;
           this.year = year;
       }
   }
   public static void main(String[] args) {
       Car car = new Car("Tesla", "Model S", 2020);
       JSONObject carJSON = new JSONObject();
       carJSON.put("make", car.make);
       carJSON.put("model", car.model);
       carJSON.put("year", car.year);
       System.out.println(carJSON.toString());
   }
}
