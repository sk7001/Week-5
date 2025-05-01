import java.io.*;

public class CSV2 {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            
            writer.write("101,John Doe,Engineering,60000\n");
            writer.write("102,Jane Smith,HR,50000\n");
            writer.write("103,Michael Brown,Marketing,55000\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");

            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
