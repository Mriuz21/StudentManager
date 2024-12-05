import java.io.*;
import java.util.ArrayList;
public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
        loadFromFile("students.dat");
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added:"+ student.getName());
    }
    public void removeStudent(String studentId){
        students.removeIf(student -> student.getId().equals(studentId));
        System.out.println("Removed student with ID: " + studentId);

    }
    public void listStudents(){
        if(students.isEmpty()){
            System.out.println("No students found");
        } else {
            for(Student student : students){
                System.out.println(student.getName() + " " + student.getId());
            }
        }
    }
    public void viewStudentDetails(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("Student Details:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("No student found with ID: " + studentId);
    }

    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        System.out.println("No student found with ID: " + studentId);
        return null;
    }


    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student data saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Student data loaded from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
