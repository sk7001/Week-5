import java.io.*;

public class CSV4 {
    public static void main(String[] args) {
        String filePath = "students.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3]);
                if (marks > 80) {
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Marks: " + columns[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
