package Classes;

import javax.swing.*;
import java.util.ArrayList;

public class Lesson {
    String title;
    String silub;
    String reference;
    Date midterm;
    Date final_;

    public ArrayList<Exam> myExams;
    public int t_exam;

    public ArrayList<Semester> ownedSemester;

    public Lesson(String title, String silub, String reference, Date m, Date f) {
        this.title = title;
        this.silub = silub;
        this.reference = reference;
        this.midterm = m;
        this.final_ = f;
        this.t_exam = 0;
        myExams = new ArrayList<>();
        ownedSemester = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getSilub() {
        return silub;
    }

    public String getReference() {
        return reference;
    }

    public Date getMidterm() {
        return midterm;
    }

    public Date getFinal_() {
        return final_;
    }

    public void addExam() {
        int t_des = Integer.parseInt(JOptionPane.showInputDialog("How many descriptive question do you want to add ?"));
        for (int i = 0; i < t_des; i++) {
            String q = JOptionPane.showInputDialog("Question ?");
            String a = JOptionPane.showInputDialog("Answer : ");
            DesProblem desProblem = new DesProblem(q, a);
            this.myExams.get(t_exam).addProblem(desProblem);
        }

        int t_fill = Integer.parseInt(JOptionPane.showInputDialog("How many fill in the blanks" +
                " question do you want to add ?"));
        for (int i = 0; i < t_fill; i++) {
            String q = JOptionPane.showInputDialog("Question ?");
            String a = JOptionPane.showInputDialog("Answer : ");
            FillProblem fillProblem = new FillProblem(q, a);
            this.myExams.get(t_exam).addProblem(fillProblem);
        }

        int t_test = Integer.parseInt(JOptionPane.showInputDialog("How many test " +
                " questions do you want to add ?"));
        for (int i = 0; i < t_test; i++) {
            String q = JOptionPane.showInputDialog("Question ?");
            ArrayList<String> options = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                StringBuilder builder = new StringBuilder();
                builder.append("Option ");
                builder.append(j + 1);
                options.add(JOptionPane.showInputDialog(builder));
            }
            int correct_option = Integer.parseInt(JOptionPane.showInputDialog("Which one is correct ? "));
            TestProblem test = new TestProblem(q, options, options.get(correct_option));
            this.myExams.get(t_exam).addProblem(test);
        }

        int t_yn = Integer.parseInt(JOptionPane.showInputDialog("How many yes/no question ? "));
        for (int i = 0; i < t_yn; i++) {
            String q = JOptionPane.showInputDialog("Question ?");
            boolean a;
            if (JOptionPane.showInputDialog("Is it true? (1 is true, anything else if wrong )").equals("1")) {
                a = true;
            } else {
                a = false;
            }
            YNProblem ynProblem = new YNProblem(q, a);
            this.myExams.get(t_exam).addProblem(ynProblem);
        }
        t_exam += 1;
    }
}
