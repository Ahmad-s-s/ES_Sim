package Classes;

import javax.swing.*;

public class FillProblem extends Problem {

    public FillProblem(String title, String solution) {
        super(title, solution);
    }

    @Override
    public boolean isValid(String answer) {
        if (answer.equals(this.solution)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void showProblem() {
        String submit = JOptionPane.showInputDialog(this.title);
        boolean res = isValid(submit);
        showResult(res);
    }

    @Override
    public void showResult(boolean valid) {
        if (valid) {
            JOptionPane.showMessageDialog(null,
                    "Your answer is correct", "answer", JOptionPane.PLAIN_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,
                    "your answer is wrong", "answer", JOptionPane.ERROR_MESSAGE);
        }
    }
}
