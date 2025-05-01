import java.io.*;
import java.util.*;

public class CSV6 {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";
        List<String[]> updatedRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            String header = br.readLine();
            updatedRecords.add(header.split(","));
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(columns[3]);
                    salary *= 1.10; 
                    columns[3] = String.format("%.2f", salary); 
                }
                updatedRecords.add(columns);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (String[] record : updatedRecords) {
                    writer.write(String.join(",", record) + "\n");
                }
            }
            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
