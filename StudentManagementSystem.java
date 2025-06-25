import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
  private static ArrayList<Student> students = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int choice;
    do {
      System.out.println("\n====== Student Record Management System ======");
      System.out.println("1. Add Student");
      System.out.println("2. View Students");
      System.out.println("3. Update Student");
      System.out.println("4. Delete Student");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addStudent();
          break;
        case 2:
          viewStudents();
          break;
        case 3:
          updateStudent();
          break;
        case 4:
          deleteStudent();
          break;
        case 5:
          System.out.println("Exiting program...");
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    } while (choice != 5);
  }

  private static void addStudent() {
    System.out.print("Enter Student ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume newline
    System.out.print("Enter Student Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Student Marks: ");
    double marks = scanner.nextDouble();

    students.add(new Student(id, name, marks));
    System.out.println("Student added successfully!");
  }

  private static void viewStudents() {
    if (students.isEmpty()) {
      System.out.println("No student records found.");
    } else {
      System.out.println("All Student Records:");
      for (Student s : students) {
        System.out.println(s);
      }
    }
  }

  private static void updateStudent() {
    System.out.print("Enter Student ID to update: ");
    int id = scanner.nextInt();
    boolean found = false;

    for (Student s : students) {
      if (s.getId() == id) {
        scanner.nextLine(); // consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new marks: ");
        double marks = scanner.nextDouble();

        s.setName(name);
        s.setMarks(marks);
        System.out.println("Student updated successfully!");
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Student ID not found.");
    }
  }

  private static void deleteStudent() {
    System.out.print("Enter Student ID to delete: ");
    int id = scanner.nextInt();
    boolean removed = students.removeIf(s -> s.getId() == id);

    if (removed) {
      System.out.println("Student deleted successfully.");
    } else {
      System.out.println("Student ID not found.");
    }
  }
}
