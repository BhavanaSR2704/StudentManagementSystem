
public class Student {

    private String name;
    private int rollNumber;
    private double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Get student name
    public String getName() {
        return name;
    }

    // Update student name
    public void setName(String name) {
        this.name = name;
    }

    // Get roll number
    public int getRollNumber() {
        return rollNumber;
    }

    // Get marks
    public double getMarks() {
        return marks;
    }

    // Update marks
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + name);
        System.out.printf("Marks: %.2f%n", marks);
    }
}
