import java.io.*;
import java.util.Base64;

public class CSV15 {

    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decrypt(String encryptedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String filePath = "employee_encrypted.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary,Email\n");
            writer.write("101,John Doe,IT," + encrypt("60000") + "," + encrypt("john.doe@example.com") + "\n");
            writer.write("102,Jane Smith,HR," + encrypt("50000") + "," + encrypt("jane.smith@example.com") + "\n");
            writer.write("103,Michael Brown,Finance," + encrypt("55000") + "," + encrypt("michael.brown@example.com") + "\n");
            System.out.println("Encrypted CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].equals("ID")) {
                    continue;
                }
                String decryptedSalary = decrypt(columns[3]);
                String decryptedEmail = decrypt(columns[4]);
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Department: " + columns[2] +
                        ", Salary: " + decryptedSalary + ", Email: " + decryptedEmail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
