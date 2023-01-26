package Classes;

abstract public class Problem {
    String title;
    String solution;
    Problem(String title, String solution) {
        this.title = title;
        this.solution = solution;
    }

    abstract public boolean isValid(String answer);

    abstract public void showProblem();

    abstract public void showResult(boolean valid);
}
