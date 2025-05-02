import java.io.*;
public class ReadLargeCSVInChunks {
   public static void main(String[] args) {
       String filePath = "merged_students.csv";
       int batchSize = 100;
       int totalRecords = 0;
       try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           String line;
           int batchCount = 0;
           br.readLine();
           while ((line = br.readLine()) != null) {
               batchCount++;
               totalRecords++;
               if (batchCount == batchSize) {
                   System.out.println("Processed " + totalRecords + " records so far.");
                   batchCount = 0;
               }
           }
           if (batchCount > 0) {
               System.out.println("Processed " + totalRecords + " records in total.");
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
