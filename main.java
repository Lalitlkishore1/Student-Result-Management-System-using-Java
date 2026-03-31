import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks;
    int total;
    double average;
    String grade;

    Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculateTotal();
        calculateAverage();
        calculateGrade();
    }

    void calculateTotal() {
        total = 0;
        for (int m : marks)
            total += m;
    }

    void calculateAverage() {
        average = total / 5.0;
    }

    void calculateGrade() {
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "Fail";
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.print("Marks   : ");
        for (int m : marks) System.out.print(m + " ");
        System.out.println();
        System.out.println("Total   : " + total);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
        System.out.println("----------------------");
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        students.add(new Student(roll, name, marks));
    }

    static void displayStudents() {
        for (Student s : students)
            s.display();
    }

    static void searchStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                s.display();
                return;
            }
        }
        System.out.println("Not found");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("New mark " + (i + 1) + ": ");
                    s.marks[i] = sc.nextInt();
                }
                s.calculateTotal();
                s.calculateAverage();
                s.calculateGrade();
                return;
            }
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        students.removeIf(s -> s.rollNo == roll);
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update 5.Delete 6.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
            }

        } while (choice != 6);
    }
}
