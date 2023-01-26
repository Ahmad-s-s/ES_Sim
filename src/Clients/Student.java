package Clients;

import Classes.Exam;
import Classes.Lesson;
import Classes.Semester;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

public class Student extends Client {
    public ArrayList<Lesson> signedLesson;
    public int t_lesson;

    public Student(String name, String lastName, String userName, String password) {
        super(name, lastName, userName, password);
        this.signedLesson = new ArrayList<>();
        t_lesson = 0;
    }

    public void signLesson() {
        String[] option_semester = new String[AllObj.semesters.size()];
        for (int i = 0; i < option_semester.length; i++) {
            option_semester[i] = AllObj.semesters.get(i).getTitle();
        }

        for (int i = 0; i < option_semester.length; i++) {
            assert option_semester[i] != null;
        }
        Semester selected = AllObj.semesters.get(JOptionPane.showOptionDialog(null,
                "Which lesson do you want to add lesson to ?", "semester", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option_semester, option_semester[0]));

        String[] option_lesson = new String[selected.myLessons.size()];

        for (int i = 0; i < selected.myLessons.size(); i++) {
            option_lesson[i] = selected.myLessons.get(i).getTitle();
        }

        for (int i = 0; i < option_lesson.length; i++) {
            assert option_lesson[i] != null;
        }

        signedLesson.add(selected.myLessons.get(JOptionPane.showOptionDialog(null, "Which lesson" +
                " do you want to add ? ", "selsect lesson", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option_lesson, option_lesson[0])));
        t_lesson += 1;
    }

    public void takeExam() {
        if (t_lesson == 0) {
            JOptionPane.showMessageDialog(null,
                    "You haven't signed in any lesson yet.","Take Exam",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = new String[t_lesson];
        for (int i = 0; i < t_lesson; i++) {
            options[i] = this.signedLesson.get(i).getTitle();
        }

        for (int i = 0; i < t_lesson; i++) {
            assert options[i] != null;
        }

        int choice = JOptionPane.showOptionDialog(null, "which lesson do you want " +
                "to take exam in ?", "select lesson", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        Lesson lesson = signedLesson.get(choice);
        String[] exam_option = new String[lesson.t_exam];
        for (int i = 0; i < lesson.t_exam; i++) {
            exam_option[i] = lesson.myExams.get(i).title;
        }

        for (int i = 0; i < exam_option.length; i++) {
            assert exam_option[i] != null;
        }

        int whichExam = JOptionPane.showOptionDialog(null, "Which exam do you want" +
                "to take ?", "Choose exam", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, exam_option, exam_option[0]);
        Exam exam = lesson.myExams.get(whichExam);
        for (int i = 0; i < exam.problems.size(); i++) {
            exam.problems.get(i).showProblem();
        }
    }
}
