import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int roll;
    String grade;

    Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public String toString() {
        return roll + " | " + name + " | " + grade;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int ch;
        do {
            System.out.println("\n1. Add\n2. Show All\n3. Find\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // consume newline

            if (ch == 1) {
                addStudent();
            } else if (ch == 2) {
                showAll();
            } else if (ch == 3) {
                findStudent();
            } else if (ch == 4) {
                deleteStudent();
            }
        } while (ch != 5);
    }

    static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        list.add(new Student(name, roll, grade));
        System.out.println("Student Added.");
    }

    static void showAll() {
        System.out.println("----- Students List -----");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    static void findStudent() {
        System.out.print("Enter roll no to search: ");
        int r = sc.nextInt();
        for (Student s : list) {
            if (s.roll == r) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter roll no to delete: ");
        int r = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).roll == r) {
                list.remove(i);
                System.out.println("Deleted.");
                return;
            }
        }
        System.out.println("Not found.");
    }
}