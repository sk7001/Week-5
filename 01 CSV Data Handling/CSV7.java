import java.io.*;
import java.util.*;

public class CSV7{
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                records.add(columns);
            }
            records.sort((record1, record2) -> Double.compare(Double.parseDouble(record2[3]), Double.parseDouble(record1[3])));
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] record = records.get(i);
                System.out.println("ID: " + record[0] + ", Name: " + record[1] + ", Department: " + record[2] + ", Salary: " + record[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
