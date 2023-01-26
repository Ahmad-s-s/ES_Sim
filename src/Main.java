

import Classes.*;
import Clients.AllObj;
import Clients.Expert;
import Clients.Student;
import Clients.Master;
import Var.Icons;

import javax.swing.*;
import javax.xml.crypto.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
//        readFromFile();
        String[] clients = {"Expert", "Master", "Student", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Which client do you want to login as ?",
                    "Log in", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    clients, clients[0]);
            if (choice == 0) {
                expertLog();
            } else if (choice == 1) {
                masterLog();
            } else if (choice == 2) {
                studentLogin();
            } else {
                int ok = JOptionPane.showConfirmDialog(null, "DO you want to exit the app ?",
                        "Exit confirm", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                if (ok == 0 || ok == -1) {
                    writeToFile();
                    exit(0);
                }
            }
        }

    }

    private static void studentLogin() {
        String username = JOptionPane.showInputDialog("Your username ? ");
        Student student = null;
        for (Student s : AllObj.students) {
            if (s.getUserName().equals(username)) {
                student = s;
                break;
            }
        }
        if (student == null) {
            JOptionPane.showMessageDialog(null,
                    "Wrong input", "title",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = {"Sign in a lesson", "Take an exam", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Which one do you want to do ?",
                    "Student Panel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (choice == 0) {
                student.signLesson();
            } else if (choice == 1) {
                student.takeExam();
            } else {
                JOptionPane.showMessageDialog(null,
                        "back to log in", "title",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }

    private static void masterLog() {
        String username = JOptionPane.showInputDialog("Your username ? ");
        Master master = null;
        for (Master m :
                AllObj.masters) {
            if (m.getUserName().equals(username)) {
                master = m;
                break;
            }
        }
        if (master == null) {
            JOptionPane.showMessageDialog(null,
                    "Wrong input", "title",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = {"Add lesson", "Add exam", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Which one do you want to do ?",
                    "Master Panel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (choice == 0) {
                master.addLesson();
            } else if (choice == 1) {
                master.addExam();
            } else {
                JOptionPane.showMessageDialog(null,
                        "back to log in", "title",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }

    private static void expertLog() {
        String username = JOptionPane.showInputDialog("Your username ?");
        Expert expert;

        if (username.equals("expert")) {
            expert = Expert.getInstance();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Wrong input", "title",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = {"Define lesson", "Define semester", "Define Master", "Define Student", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "What do you want to do ?",
                    "Expert Panel", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (choice == 0) {
                expert.defineLesson();
            } else if (choice == 1) {
                expert.defineSemester();
            } else if (choice == 2) {
                expert.defineMaster();
            } else if (choice == 3) {
                expert.defineStudent();
            } else {
                return;
            }
        }
    }

    private static void writeToFile() {
        File lessons = new File("lessons.txt");
        File semesters = new File("semesters.txt");
        File masters = new File("masters.txt");
        File students = new File("students.txt");
        try {
            lessons.createNewFile();
            semesters.createNewFile();
            masters.createNewFile();
            students.createNewFile();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
        FileWriter lessonWriter;
        FileWriter semesterWriter;
        FileWriter mastersWriter;
        FileWriter studentsWriter;

        try {
            lessonWriter = new FileWriter(lessons, false);
            semesterWriter = new FileWriter(semesters, false);
            mastersWriter = new FileWriter(masters, false);
            studentsWriter = new FileWriter(students, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            //write the lessons to file :
            lessonWriter.write(AllObj.lessons.size() + "\n");
            for (int i = 0; i < AllObj.lessons.size(); i++) {
                lessonWriter.write(AllObj.lessons.get(i).getTitle() + '\n');
                lessonWriter.write(AllObj.lessons.get(i).t_exam + '\n');
                for (int j = 0; j < AllObj.lessons.get(i).t_exam; j++) {
                    lessonWriter.write(AllObj.lessons.get(i).myExams.get(j).title + '\n');
                    lessonWriter.write(AllObj.lessons.get(i).myExams.get(j).t_problem + '\n');
                    for (int k = 0; k < AllObj.lessons.get(i).myExams.get(j).t_problem; k++) {
                        lessonWriter.write(AllObj.lessons.get(i).myExams.get(j).problems.get(k).title + '\n');
                        lessonWriter.write(AllObj.lessons.get(i).myExams.get(j).problems.get(k).solution + '\n');
                    }
                }
            }
            lessonWriter.close();

            semesterWriter.write(AllObj.semesters.size() + '\n');
            for (int i = 0; i < AllObj.semesters.size(); i++) {
                semesterWriter.write(AllObj.semesters.get(i).getTitle() + '\n');
                semesterWriter.write(AllObj.semesters.get(i).t_lessons + '\n');
                for (int j = 0; j < AllObj.semesters.get(i).t_lessons; j++) {
                    semesterWriter.write(AllObj.semesters.get(i).myLessons.get(j).getTitle() + '\n');
                }
            }
            semesterWriter.close();

            mastersWriter.write(AllObj.masters.size() + '\n');
            for (int i = 0; i < AllObj.masters.size(); i++) {
                mastersWriter.write(AllObj.masters.get(i).getUserName() + '\n');
                mastersWriter.write(AllObj.masters.get(i).myLessons.size() + '\n');
                for (int j = 0; j < AllObj.masters.get(i).myLessons.size(); j++) {
                    mastersWriter.write(AllObj.masters.get(i).myLessons.get(j).getTitle() + '\n');
                }
            }
            mastersWriter.close();

            studentsWriter.write(AllObj.students.size() + '\n');
            for (int i = 0; i < AllObj.students.size(); i++) {
                studentsWriter.write(AllObj.students.get(i).getUserName() + '\n');
                studentsWriter.write((AllObj.students.get(i).t_lesson) + '\n');
                for (int j = 0; j < AllObj.students.get(i).t_lesson; j++) {
                    studentsWriter.write(AllObj.students.get(i).signedLesson.get(j).getTitle() + '\n');
                }
            }
            studentsWriter.close();

        } catch (Exception e) {
            System.out.println("An error accused");
        }
    }

    private static void readFromFile() {
        File lessons = new File("lessons.txt");
        File semesters = new File("semesters.txt");
        File masters = new File("masters.txt");
        File students = new File("students.txt");
        try {
            lessons.createNewFile();
            semesters.createNewFile();
            masters.createNewFile();
            students.createNewFile();
            Scanner lessonScanner = new Scanner(lessons);
            Scanner semesterScanner = new Scanner(semesters);
            Scanner masterScanner = new Scanner(masters);
            Scanner studentsScanner = new Scanner(students);

            //read from lessons :
            int t_lessons = lessonScanner.nextInt();
            for (int i = 0; i < t_lessons; i++) {
                String title = lessonScanner.nextLine();
                Lesson test = new Lesson(title, "silub", "refrence", null, null);
                int t_exam = lessonScanner.nextInt();
                test.t_exam = t_exam;
                for (int j = 0; j < t_exam; j++) {
                    Exam exam = new Exam(lessonScanner.nextLine());
                    int t_problem = lessonScanner.nextInt();
                    exam.t_problem = t_problem;
                    for (int k = 0; k < t_problem; k++) {
                        String q = lessonScanner.nextLine();
                        String a = lessonScanner.nextLine();
                        FillProblem problem = new FillProblem(q, a);
                        exam.problems.add(problem);
                    }
                    test.myExams.add(exam);
                }
                AllObj.lessons.add(test)
                ;
            }

            int t_semester = semesterScanner.nextInt();
            for (int i = 0; i < t_semester; i++) {
                String title = semesterScanner.nextLine();
                Semester semester = new Semester(title, null, null, null);
                int t_lessons_semester = semesterScanner.nextInt();
                semester.t_lessons = t_lessons_semester;
                for (int j = 0; j < t_lessons_semester; j++) {
                    String lesson_title = semesterScanner.nextLine();
                    Lesson lesson = new Lesson(lesson_title, "sylub", "refrence", null, null);
                    semester.myLessons.add(lesson);
                }
                AllObj.semesters.add(semester);
            }

            int t_master = masterScanner.nextInt();
            for (int i = 0; i < t_master; i++) {
                String username = masterScanner.nextLine();
                Master master = new Master("name", "last name", username, "password");
                int t_lesson = masterScanner.nextInt();
                for (int j = 0; j < t_lesson; j++) {
                    String title =masterScanner.nextLine();
                    Lesson lesson = new Lesson(title, "sylub", "refrence", null, null);
                    master.myLessons.add(lesson);
                }
                AllObj.masters.add(master);
            }

            int t_student = studentsScanner.nextInt();
            for (int i = 0; i < t_student; i++) {
                String username = studentsScanner.nextLine();
                Student student = new Student("name", "lastname", username, "password");
                int t_lesson = semesterScanner.nextInt();
                for (int j = 0; j < t_lesson; j++) {
                    String title =studentsScanner.nextLine();
                    Lesson lesson = new Lesson(title, "sylub", "refrence", null, null);
                    student.signedLesson.add(lesson);
                }
                AllObj.students.add(student);
            }
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }

}