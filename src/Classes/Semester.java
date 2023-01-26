package Classes;

import Clients.AllObj;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

public class Semester {
    String title;
    Date begin;
    Date end;
    Date scoreDate;

    public ArrayList<Lesson> myLessons;
    public int t_lessons;
    public Semester(String title, Date begin, Date end, Date scoreDate) {
        this.title = title;
        this.begin = begin;
        this.end = end;
        this.scoreDate = scoreDate;
        myLessons = new ArrayList<>();
        t_lessons = 0;
    }

    public void addLesson() {
        int t = Integer.parseInt(JOptionPane.showInputDialog("How many lesson do you want to add ? "));
        String[] options = new String[AllObj.lessons.size()];
        for (int i = 0; i < AllObj.lessons.size(); i++) {
            options[i] = AllObj.lessons.get(i).title;
        }
        for (int i = 0; i < options.length; i++) {
            assert options[i] != null;
        }
        for (int i = 0; i < t; i++) {
            int choice = JOptionPane.showOptionDialog(null, "Which lesson do you want to add to" +
                    " this term ?", "add lesson to term", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            this.myLessons.add(AllObj.lessons.get(choice));
        }
        t_lessons += 1;
    }

    public String getTitle() {
        return title;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public Date getScoreDate() {
        return scoreDate;
    }
}
