package laba8;

import library.*;

import javax.swing.*;
import java.awt.*;

import static laba8.HelpMethods.getNamesOfBranches;

public class BranchDialog extends JDialog {
    public BranchDialog(Frame owner, String title, boolean modal, Library library, JList list) {
        super(owner, title, modal);

        Container container = this.getContentPane();

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Введите название нового отдела: ");
        JTextField textField = new JTextField();
        JButton button = new JButton("Создать");

        button.addActionListener(e -> {
            library.addBranch(new Branch(textField.getText()));
            textField.setText("");
            list.setModel(new ListOfBranchesModel(getNamesOfBranches(library)));

        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        panel.setLayout(new GridLayout(0, 1));

        container.add(panel);

        this.pack();
    }
}
