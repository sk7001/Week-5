import java.io.*;
import java.sql.*;
public class ExportEmployeesToCSVFromDB {
   public static void main(String[] args) {
       String jdbcURL = "jdbc:mysql://localhost:5000/db";
       String username = "admin";
       String password = "admin";
       String csvFilePath = "employees_report.csv";
       String sql = "SELECT employee_id, name, department, salary FROM employees";
       try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath))) {
           fileWriter.write("Employee ID,Name,Department,Salary\n");
           while (result.next()) {
               int id = result.getInt("employee_id");
               String name = result.getString("name");
               String department = result.getString("department");
               double salary = result.getDouble("salary");
               fileWriter.write(id + "," + name + "," + department + "," + salary + "\n");
           }
           System.out.println("CSV file created successfully.");
       } catch (SQLException | IOException e) {
           e.printStackTrace();
       }
   }
}
