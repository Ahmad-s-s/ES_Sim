package Clients;

import Classes.Exam;
import Classes.Lesson;
import Classes.Problem;
import Classes.Semester;

import java.util.ArrayList;

public class AllObj {
    public static ArrayList<Client> allClients = new ArrayList<>();
    public static ArrayList<Master> masters = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Semester> semesters = new ArrayList<>();
    public static ArrayList<Lesson> lessons = new ArrayList<>();
    public static ArrayList<Exam> exams = new ArrayList<>();
    public static ArrayList<Problem> problems = new ArrayList<>();

    static void addMaster(Master master) {
        AllObj.masters.add(master);
        AllObj.allClients.add(master);
    }

    static void addStudent(Student student) {
        AllObj.allClients.add(student);
        AllObj.students.add(student);
    }

    static void removeMaster(Master master) {
        AllObj.allClients.remove(master);
        AllObj.masters.remove(master);
    }

    static void removeStudent(Student student) {
        AllObj.allClients.remove(student);
        AllObj.students.remove(student);
    }

    static void addSemester(Semester semester) {
        AllObj.semesters.add(semester);
    }

    static void addLesson(Lesson lesson) {
        AllObj.lessons.add(lesson);
    }

    static void addExam (Exam exam) {
        AllObj.exams.add(exam);
    }

    static void addProblem(Problem problem){
        AllObj.problems.add(problem);
    }

    static void removeSemester(Semester semester) {
        AllObj.semesters.remove(semester);
    }

    static void removeLesson(Lesson lesson) {
        AllObj.lessons.remove(lesson);
    }

    static void removeExam(Exam exam) {
        AllObj.exams.remove(exam);
    }

    static void removeProblem(Problem problem){
        AllObj.problems.remove(problem);
    }

}
