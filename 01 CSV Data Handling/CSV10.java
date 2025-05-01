import java.io.*;
import java.util.*;

public class CSV10 {
    public static void main(String[] args) {
        String file1Path = "students1.csv";
        String file2Path = "students2.csv";
        String outputFilePath = "merged_students.csv";

        Map<String, String[]> file1Data = new HashMap<>();
        Map<String, String[]> file2Data = new HashMap<>();

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file1Path))) {
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(",");
                    if (columns.length < 3) continue;
                    file1Data.put(columns[0].trim(), new String[]{columns[1].trim(), columns[2].trim()});
                }
            }
            try (BufferedReader br = new BufferedReader(new FileReader(file2Path))) {
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(",");
                    if (columns.length < 3) continue;
                    file2Data.put(columns[0].trim(), new String[]{columns[1].trim(), columns[2].trim()});
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                bw.write("ID,Name,Age,Marks,Grade\n");
                for (String id : file1Data.keySet()) {
                    String[] data1 = file1Data.get(id);
                    String[] data2 = file2Data.get(id);
                    if (data2 != null) {
                        bw.write(id + "," + data1[0] + "," + data1[1] + "," + data2[0] + "," + data2[1] + "\n");
                    }
                }
            }

            System.out.println("Files merged successfully into " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
