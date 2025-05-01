import java.io.*;
import java.util.*;

public class CSV12 {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> ids = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 1) continue;
                String id = columns[0].trim();
                if (!ids.add(id)) {
                    duplicates.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate records:");
            for (String dup : duplicates) {
                System.out.println(dup);
            }
        }
    }
}
