package Classes;

import javax.swing.*;
import java.util.ArrayList;

public class TestProblem extends Problem{

    ArrayList<String> choices;

    TestProblem(String title, ArrayList<String> choices, String solution) {
        super(title, solution);
        this.choices = choices;
    }

    @Override
    public boolean isValid(String answer) {
        if (answer.equals(this.solution)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void showProblem() {
        String[] options = new String[choices.size()];
        for (int i = 0; i < choices.size(); i++) {
            options[i] = choices.get(i);
        }

        for (int i = 0; i < options.length; i++) {
            assert options[i] != null;
        }

        int choice = JOptionPane.showOptionDialog(null, this.title, "test",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        boolean res = isValid(options[choice]);
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
