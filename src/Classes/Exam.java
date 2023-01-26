package Classes;

import java.util.ArrayList;

public class Exam {
    public String title;
    public ArrayList<Problem> problems;

    public Exam(String title) {
        this.title = title;
        this.problems = new ArrayList<>();
    }

    void addProblem(Problem problem) {
        this.problems.add(problem);
    }
}
