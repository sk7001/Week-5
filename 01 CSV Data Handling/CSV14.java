import java.io.*;
import java.nio.file.*;
import org.json.*;

public class CSV14 {

    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonString);
            String csv = CDL.toString(jsonArray);
            Files.write(Paths.get(csvFilePath), csv.getBytes());
            System.out.println("JSON converted to CSV successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        try {
            String csvString = new String(Files.readAllBytes(Paths.get(csvFilePath)));
            JSONArray jsonArray = CDL.toJSONArray(csvString);
            Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes());
            System.out.println("CSV converted to JSON successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "students.json";
        String csvOutput = "students.csv";
        String jsonOutput = "students_converted.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}
