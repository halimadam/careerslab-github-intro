
public class Student {
    private String name;
    private int studentID;
    private double mark;

    public Student(String name, int studentID, double mark) {
        this.name = name;
        this.studentID = studentID;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public double getMark() {
        return mark;
    }

    public void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("Mark: " + mark + "%");
        System.out.println("-------------------------");
    }
}
