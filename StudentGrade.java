import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double[] marks;

    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }
}

class StudentGradeManagementSystem {
    private ArrayList<Student> students;

    public StudentGradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int rollNumber, double[] marks) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setMarks(marks);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void deleteStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayStudentInfo(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Subject Marks:");
                double[] marks = student.getMarks();
                for (int i = 0; i < marks.length; i++) {
                    System.out.println("Subject " + (i + 1) + ": " + marks[i]);
                }
                double percentage = calculatePercentage(marks);
                System.out.println("Overall Percentage: " + percentage);
                System.out.println("Grade: " + calculateGrade(percentage));
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private double calculatePercentage(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else if (percentage >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();
                    double[] marks = new double[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        marks[i] = scanner.nextDouble();
                    }
                    system.addStudent(new Student(name, rollNumber, marks));
                    break;
                case 2:
                    System.out.print("Enter roll number of student to update: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.print("Enter number of subjects: ");
                    int updateNumSubjects = scanner.nextInt();
                    double[] updateMarks = new double[updateNumSubjects];
                    for (int i = 0; i < updateNumSubjects; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        updateMarks[i] = scanner.nextDouble();
                    }
                    system.updateStudent(updateRollNumber, updateMarks);
                    break;
                case 3:
                    System.out.print("Enter roll number of student to delete: ");
                    int deleteRollNumber = scanner.nextInt();
                    system.deleteStudent(deleteRollNumber);
                    break;
                case 4:
                    System.out.print("Enter roll number of student to display information: ");
                    int displayRollNumber = scanner.nextInt();
                    system.displayStudentInfo(displayRollNumber);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
