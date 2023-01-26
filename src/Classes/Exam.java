package Classes;

import java.util.ArrayList;

public class Exam {
    public String title;
    public ArrayList<Problem> problems;
    public int t_problem;

    public Exam(String title) {
        this.title = title;
        this.problems = new ArrayList<>();
        t_problem = 0;
    }

    void addProblem(Problem problem) {
        this.problems.add(problem);
        t_problem += 1;
    }
}
