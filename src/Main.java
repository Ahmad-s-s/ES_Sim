

import Clients.AllObj;
import Clients.Expert;
import Clients.Student;
import Clients.Master;
import Var.Icons;

import javax.swing.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.ERROR_MESSAGE);

//        JOptionPane.showConfirmDialog(null, "bro did you code ?",
//                "title", JOptionPane.OK_CANCEL_OPTION);
//        JOptionPane.showConfirmDialog(null, "Q?", "title", JOptionPane.YES_NO_CANCEL_OPTION);

//        System.out.println(JOptionPane.showInputDialog(null, "Your name : ", "title",
//                JOptionPane.INFORMATION_MESSAGE));
        String[] clients = {"Expert", "Master", "Student", "Exit"};
        while (true){
            int choice = JOptionPane.showOptionDialog(null, "Which client do you want to login as ?",
                    "Log in", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    clients, clients[0]);
            if (choice == 0) {
                expertLog();
            } else if (choice == 1) {
                masterLog();
            } else if (choice == 2){
                studentLogin();
            }else {
                exit(0);
            }
        }

    }

    private static void studentLogin() {
        String username = JOptionPane.showInputDialog("Your username ? ");
        Student student = null;
        for (Student s: AllObj.students) {
            if (s.getUserName().equals(username)){
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
        while (true){
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
        while (true){
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

        if (username.equals("expert")){
            expert = Expert.getInstance();
        }else {
            JOptionPane.showMessageDialog(null,
                    "Wrong input", "title",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = {"Define lesson", "Define semester", "Define Master", "Define Student", "Exit"};
        while (true){
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

}