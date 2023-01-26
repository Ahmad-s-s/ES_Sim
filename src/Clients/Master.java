package Clients;

import Classes.Exam;
import Classes.Lesson;
import Classes.Semester;
import Var.Icons;

import javax.swing.*;
import java.util.ArrayList;

public class Master extends Client {
    ArrayList<Lesson> myLessons;

    Master(String name, String lastName, String userName, String password) {
        super(name, lastName, userName, password);
        myLessons = new ArrayList<>();
    }

    public void addLesson() {
        String[] semesters = new String[AllObj.semesters.size()];
        for (int i = 0; i < AllObj.semesters.size(); i++) {
            semesters[i] = AllObj.semesters.get(i).getTitle();
        }

        for (int i = 0; i < semesters.length; i++) {
            assert semesters[i] != null;
        }

        int choice = JOptionPane.showOptionDialog(null, "Which semester do you want to present a lesson to ?",
                "Select term", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                semesters, semesters[0]);
        Semester selected = AllObj.semesters.get(choice);
        String[] lessons = new String[selected.myLessons.size()];
        for (int i = 0; i < selected.myLessons.size(); i++) {
            lessons[i] = selected.myLessons.get(i).getTitle();
        }

        for (int i = 0; i < lessons.length; i++) {
            assert lessons[i] != null;
        }

        choice = JOptionPane.showOptionDialog(null, "Which lesson do you want to add ? ",
                "select lesson", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                lessons, lessons[0]);
        selected.myLessons.get(choice).ownedSemester.add(selected);
        this.myLessons.add(selected.myLessons.get(choice));

        JOptionPane.showMessageDialog(null, "Added successfully !", "Add",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void addExam() {
        String[] options = new String[this.myLessons.size()];
        for (int i = 0; i < this.myLessons.size(); i++) {
            options[i] = myLessons.get(i).getTitle();
        }
        int chosen_lesson = JOptionPane.showOptionDialog(null, "Which lesson do you want to addd exam to ?",
                "add exam", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        String examTitle = JOptionPane.showInputDialog("Exam title ?");
        Exam exam = new Exam(examTitle);
        this.myLessons.get(chosen_lesson).myExams.add(exam);
        this.myLessons.get(chosen_lesson).addExam();
    }
}
