import java.io.*;
import java.util.regex.*;

public class CSV8 {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            String header = br.readLine();
            lineNumber++;
            System.out.println("Header: " + header);
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] columns = line.split(",");
                if (columns.length < 3) {
                    System.out.println("Invalid format at line " + lineNumber + ": " + line);
                    continue;
                }
                String email = columns[1].trim();
                String phone = columns[2].trim();
                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();
                if (!validEmail || !validPhone) {
                    System.out.println("Invalid data at line " + lineNumber + ": " + line);
                    if (!validEmail) {
                        System.out.println(" - Invalid email: " + email);
                    }
                    if (!validPhone) {
                        System.out.println(" - Invalid phone number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
