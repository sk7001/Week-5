import java.io.*;
public class SearchEmployeeByName {
   public static void main(String[] args) {
       String filePath = "employees.csv";
       String searchName = "John Doe";
       try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           String line;
           br.readLine();
           while ((line = br.readLine()) != null) {
               String[] columns = line.split(",");
               if (columns[1].equalsIgnoreCase(searchName)) {
                   System.out.println("Employee Found: " + columns[1]);
                   System.out.println("Department: " + columns[2]);
                   System.out.println("Salary: " + columns[3]);
                   break;
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
