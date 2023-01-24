package Clients;

import Classes.Date;
import Classes.Semester;
import Var.Icons;

import javax.swing.*;

public class Expert extends Client {
    // singleton pattern, the username is expert, and the password is 1234

    private Expert instance;

    private Expert(String name, String lastName, String userName, String password) {
        super(name, lastName, userName, password);
    }

    Expert getInstance() {
        if (instance == null) {
            instance = new Expert("MS.", "Hoseini", "expert", "1234");
        }
        return instance;
    }

    void defineMaster() {
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
        JOptionPane.showMessageDialog(null, "Added successfully !", "Add" ,
                JOptionPane.PLAIN_MESSAGE);
    }

    void defineStudent() {
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
        JOptionPane.showMessageDialog(null, "Added successfully !", "Add" ,
                JOptionPane.PLAIN_MESSAGE);
    }

    void defineSemester() {
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
        Date scoreDate = new Date(y ,m, d);

        Semester semester = new Semester(title, begin, end, scoreDate);
        AllObj.addSemester(semester);

        JOptionPane.showMessageDialog(null, "Added successfully !", "Add" ,
                JOptionPane.PLAIN_MESSAGE);
    }


}
