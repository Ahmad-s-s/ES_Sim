

import Var.Icons;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Hello", "title", JOptionPane.ERROR_MESSAGE);

//        JOptionPane.showConfirmDialog(null, "bro did you code ?",
//                "title", JOptionPane.OK_CANCEL_OPTION);
//        JOptionPane.showConfirmDialog(null, "Q?", "title", JOptionPane.YES_NO_CANCEL_OPTION);

//        System.out.println(JOptionPane.showInputDialog(null, "Your name : ", "title",
//                JOptionPane.INFORMATION_MESSAGE));

        String[] responses = {"option 1", "option 2", "option 3"};
        JOptionPane.showOptionDialog(null,
                "Add test", "Title", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, Icons.add, responses, responses[0]);
    }

}