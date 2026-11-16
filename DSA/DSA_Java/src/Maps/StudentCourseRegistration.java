package Maps;

import java.util.HashMap;

public class StudentCourseRegistration {

    HashMap<Integer, HashMap<String, Boolean>> students = new HashMap<>();

    void registerStudent(int studentID) {

        if (students.containsKey(studentID)) {
            System.out.println("Student already registered!");
            return;
        }

        students.put(studentID, new HashMap<>());
        System.out.println("Student registered successfully!");
    }

    void addCourse(int studentID, String course) {

        if (!students.containsKey(studentID)) {
            System.out.println("Student not found!");
            return;
        }

        HashMap<String, Boolean> courses = students.get(studentID);

        if (courses.containsKey(course)) {
            System.out.println("Course already registered!");
            return;
        }

        courses.put(course, true);
        System.out.println(course + " added successfully!");
    }

    void searchStudent(int studentID) {

        if (!students.containsKey(studentID)) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student ID: " + studentID);
        System.out.println("Courses: " + students.get(studentID).keySet());
    }

    void removeCourse(int studentID, String course) {

        if (!students.containsKey(studentID)) {
            System.out.println("Student not found!");
            return;
        }

        HashMap<String, Boolean> courses = students.get(studentID);

        if (courses.remove(course) != null) {
            System.out.println(course + " removed successfully!");
        } else {
            System.out.println("Course not found!");
        }
    }

    void displayRecords() {

        for (Integer studentID : students.keySet()) {

            System.out.println("Student ID: " + studentID);
            System.out.println("Courses: " + students.get(studentID).keySet());
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {

        StudentCourseRegistration obj = new StudentCourseRegistration();

        obj.registerStudent(101);

        obj.addCourse(101, "Java");
        obj.addCourse(101, "Python");
        obj.addCourse(101, "DBMS");

        obj.addCourse(101, "Java");

        obj.searchStudent(101);

        obj.removeCourse(101, "Python");

        obj.searchStudent(101);

        System.out.println("\nAll Registration Records:");
        obj.displayRecords();
    }
}
