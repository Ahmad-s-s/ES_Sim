package Classes;

import Var.Icons;

import javax.swing.*;

public class YNProblem extends Problem{
    boolean answer;

    YNProblem(String title, boolean b) {
        super(title, "true");
        this.answer = b;
        if (b) {
            this.solution = "true";
        }
        else {
            this.solution = "false";
        }
    }


    @Override
    public boolean isValid(String answer) {
        if (answer.equals(this.solution))
            return true;
        else
            return false;
    }

    @Override
    public void showProblem() {
        String[] options = {"True", "False"};
        int choice = JOptionPane.showOptionDialog(null, this.title, "YES/NO", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,options, options[0]);
        String answer;
        if (choice == 0) {
            answer = "true";
        }else {
            answer = "false";
        }
        boolean res = isValid(answer);
        showResult(res);
    }

    @Override
    public void showResult(boolean valid) {
        if (valid) {
            JOptionPane.showMessageDialog(null,
                    "Your answer is correct", "The yes/no question answer",
                    JOptionPane.PLAIN_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,
                    "Your answer is wrong", "The yes/no question answer",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
