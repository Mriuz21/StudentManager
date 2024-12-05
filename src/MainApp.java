import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. View Student Details");
                System.out.println("4. Borrow Item");
                System.out.println("5. Return Item");
                System.out.println("6. Save Data");
                System.out.println("7. Load Data");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                // Read and validate choice
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        manager.addStudent(new Student(name, id));
                        break;

                    case 2:
                        manager.listStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID to view details: ");
                        String viewId = scanner.nextLine();
                        manager.viewStudentDetails(viewId);
                        break;

                    case 4:
                        System.out.print("Enter student ID: ");
                        String borrowId = scanner.nextLine();
                        System.out.print("Enter item to borrow: ");
                        String item = scanner.nextLine();
                        manager.getStudentById(borrowId).borrowItem(item);
                        break;

                    case 5:
                        System.out.print("Enter student ID: ");
                        String returnId = scanner.nextLine();
                        System.out.print("Enter item to return: ");
                        String returnItem = scanner.nextLine();
                        manager.getStudentById(returnId).returnItem(returnItem);
                        break;

                    case 6:
                        manager.saveToFile("students.dat");
                        break;

                    case 7:
                        manager.loadFromFile("students.dat");
                        break;

                    case 8:
                        System.out.println("Exiting program...");
                        manager.saveToFile("students.dat");
                        return;

                    default:
                        System.out.println("Invalid choice! Please select an option between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 8.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
