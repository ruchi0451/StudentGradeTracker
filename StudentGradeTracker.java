import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return grades.isEmpty() ? 0 : max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return grades.isEmpty() ? 0 : min;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = sc.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                student.grades.add(grade);
            }
            sc.nextLine(); // Consume newline
            studentList.add(student);
        }

        // Summary Report
        System.out.println("\n=== Student Summary Report ===");
        for (Student s : studentList) {
            System.out.println("\nStudent: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.printf("Average Grade: %.2f\n", s.getAverage());
            System.out.println("Highest Grade: " + s.getHighest());
            System.out.println("Lowest Grade: " + s.getLowest());
        }

        sc.close();
    }
}
