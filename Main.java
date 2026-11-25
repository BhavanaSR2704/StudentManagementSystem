
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = readInt();

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
                    System.out.println(
                        "Thank you for using Student Management System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please enter 1 to 5."
                    );
            }

        } while (choice != 5);

        sc.close();
    }

    // Add a new student
    static void addStudent() {

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty!");
            return;
        }

        System.out.print("Enter roll number: ");
        int rollNumber = readInt();

        if (rollNumber <= 0) {
            System.out.println("Roll number must be positive!");
            return;
        }

        if (findStudent(rollNumber) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        System.out.print("Enter marks (0-100): ");
        double marks = readMarks();

        Student student = new Student(name, rollNumber, marks);

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }

    // View all students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found!");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");

        for (Student student : students) {

            student.displayDetails();

            System.out.println("-------------------------------------");
        }
    }

    // Update student details
    static void updateStudent() {

        System.out.print("Enter roll number to update: ");
        int rollNumber = readInt();

        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter new student name: ");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("Student name cannot be empty!");
            return;
        }

        System.out.print("Enter new marks (0-100): ");
        double newMarks = readMarks();

        student.setName(newName);
        student.setMarks(newMarks);

        System.out.println("\nStudent details updated successfully!");
    }

    // Delete student
    static void deleteStudent() {

        System.out.print("Enter roll number to delete: ");
        int rollNumber = readInt();

        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(student);

        System.out.println("\nStudent deleted successfully!");
    }

    // Find student using roll number
    static Student findStudent(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    // Read integer safely
    static int readInt() {

        try {
            return Integer.parseInt(sc.nextLine().trim());

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Read marks safely
    static double readMarks() {

        while (true) {

            try {
                double marks = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(marks) &&
                    marks >= 0 && marks <= 100) {

                    return marks;
                }

                System.out.println(
                    "Invalid marks! Enter marks between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input! Please enter numeric marks."
                );
            }

            System.out.print("Enter marks again: ");
        }
    }
}
