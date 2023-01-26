package Clients;

import Classes.Date;
import Classes.Exam;
import Classes.Lesson;
import Classes.Semester;
import Var.Icons;

import javax.swing.*;

public class Expert extends Client {
    // singleton pattern, the username is expert, and the password is 1234

    private static Expert instance;

    private Expert(String name, String lastName, String userName, String password) {
        super(name, lastName, userName, password);
    }

    public static Expert getInstance() {
        if (instance == null) {
            instance = new Expert("MS.", "Hoseini", "expert", "1234");
        }
        return instance;
    }

    public void defineMaster() {
        String[] options = {"OK", "CANCEL"};
        int option = JOptionPane.showOptionDialog(null, "You are going to add a master", "Add",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Icons.add,
                options, options[0]);
        if (option == 1) {
            return;
        }
        String name = JOptionPane.showInputDialog(null,
                "Master's name : ", "First name",
                JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null,
                "Master's last name : ", "Last Name",
                JOptionPane.INFORMATION_MESSAGE);
        String userName = JOptionPane.showInputDialog(null,
                "user name : ", "USERNAME",
                JOptionPane.INFORMATION_MESSAGE
        );
        String password = JOptionPane.showInputDialog(null,
                "password : ", "PASSWORD",
                JOptionPane.INFORMATION_MESSAGE);
        Master master = new Master(name, lastName, userName, password);
        AllObj.addMaster(master);
        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void defineStudent() {
        String[] options = {"OK", "CANCEL"};
        int option = JOptionPane.showOptionDialog(null,
                "You are going to add a student", "Add",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Icons.add,
                options, options[0]);
        if (option == 1) {
            return;
        }
        String name = JOptionPane.showInputDialog(null,
                "student's name : ", "First name",
                JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null,
                "student's last name : ", "Last Name",
                JOptionPane.INFORMATION_MESSAGE);
        String userName = JOptionPane.showInputDialog(null,
                "user name : ", "USERNAME",
                JOptionPane.INFORMATION_MESSAGE
        );
        String password = JOptionPane.showInputDialog(null,
                "password : ", "PASSWORD",
                JOptionPane.INFORMATION_MESSAGE);
        Student student = new Student(name, lastName, userName, password);
        AllObj.addStudent(student);
        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void defineSemester() {
        String[] options = {"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null,
                "You are going to add semester", "Add",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Icons.add,
                options, options[0]);
        if (option == 1) {
            return;
        }

        String title = JOptionPane.showInputDialog(null,
                "The semester title : ", "set title",
                JOptionPane.INFORMATION_MESSAGE);

        int y = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The start year : ", "year",
                JOptionPane.INFORMATION_MESSAGE));
        int m = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The start month : ", "month",
                JOptionPane.INFORMATION_MESSAGE));
        int d = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The start day : ", "day",
                JOptionPane.INFORMATION_MESSAGE));
        Date begin = new Date(y, m, d);

        y = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The end year : ", "year",
                JOptionPane.INFORMATION_MESSAGE));
        m = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The end month : ", "month",
                JOptionPane.INFORMATION_MESSAGE));
        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The end day : ", "day",
                JOptionPane.INFORMATION_MESSAGE));
        Date end = new Date(y, m, d);

        y = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The score year : ", "year",
                JOptionPane.INFORMATION_MESSAGE));
        m = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The score month : ", "month",
                JOptionPane.INFORMATION_MESSAGE));
        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The score day : ", "day",
                JOptionPane.INFORMATION_MESSAGE));
        Date scoreDate = new Date(y, m, d);

        Semester semester = new Semester(title, begin, end, scoreDate);
        semester.addLesson();
        AllObj.addSemester(semester);

        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
                JOptionPane.PLAIN_MESSAGE);

    }

    public void defineLesson() {
        String[] options = {"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null,
                "You are going to add lesson", "Add",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Icons.add,
                options, options[0]);
        if (option == 1) {
            return;
        }

        String title = JOptionPane.showInputDialog(null,
                "The lesson title : ", "set title",
                JOptionPane.INFORMATION_MESSAGE);

        String syllabus = JOptionPane.showInputDialog(null,
                "The lesson syllabus : ", "set title",
                JOptionPane.INFORMATION_MESSAGE);
        String ref = JOptionPane.showInputDialog(null,
                "The lesson reference : ", "set title",
                JOptionPane.INFORMATION_MESSAGE);

        int y = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The midterm year : ", "year",
                JOptionPane.INFORMATION_MESSAGE));
        int m = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The midterm month : ", "month",
                JOptionPane.INFORMATION_MESSAGE));
        int d = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The midterm day : ", "day",
                JOptionPane.INFORMATION_MESSAGE));
        Date mid = new Date(y, m, d);

        y = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The final year : ", "year",
                JOptionPane.INFORMATION_MESSAGE));
        m = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The final month : ", "month",
                JOptionPane.INFORMATION_MESSAGE));
        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                "The final day : ", "day",
                JOptionPane.INFORMATION_MESSAGE));
        Date fin = new Date(y, m, d);

        Lesson lesson = new Lesson(title, syllabus, ref, mid, fin);
        AllObj.addLesson(lesson);


        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
                JOptionPane.PLAIN_MESSAGE);
    }

//    void defineExam() {
//        String[] options = {"OK", "Cancel"};
//        int option = JOptionPane.showOptionDialog(null,
//                "You are going to add exam", "Add",
//                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Icons.add,
//                options, options[0]);
//        if (option == 1) {
//            return;
//        }
//
//        String title = JOptionPane.showInputDialog(null,
//                "The exam title : ", "set title",
//                JOptionPane.INFORMATION_MESSAGE);
//        Exam exam = new Exam(title);
//        AllObj.addExam(exam);
//
//        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
//                JOptionPane.PLAIN_MESSAGE);
//    }


}
