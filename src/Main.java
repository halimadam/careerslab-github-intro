
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n===== STUDENT GRADE MANAGER =====");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Search for student");
            System.out.println("4. Calculate class average");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        calculateAverage();
                        break;

                    case 5:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    public static void addStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Student student : students) {
                if (student.getStudentID() == id) {
                    System.out.println("Student ID already exists.");
                    return;
                }
            }

            System.out.print("Enter exam mark (0-100): ");
            double mark = Double.parseDouble(scanner.nextLine());

            if (mark < 0 || mark > 100) {
                System.out.println("Mark must be between 0 and 100.");
                return;
            }

            Student newStudent = new Student(name, id, mark);
            students.add(newStudent);

            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for ID and mark.");
        }
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter student ID to search: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            for (Student student : students) {
                if (student.getStudentID() == id) {
                    System.out.println("\nStudent found:");
                    student.displayStudent();
                    return;
                }
            }

            System.out.println("No student found with that ID.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid student ID.");
        }
    }

    public static void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No student marks available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMark();
        }

        double average = total / students.size();

        System.out.printf("Class average: %.2f%%%n", average);
    }
}
