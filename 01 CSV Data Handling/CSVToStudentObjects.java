import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
    }
}

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 4) continue;
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                double marks = Double.parseDouble(columns[3].trim());
                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
