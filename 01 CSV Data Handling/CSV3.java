import java.io.*;

public class CSV3{
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int rowCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((br.readLine()) != null) {
                rowCount++;
            }
            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
