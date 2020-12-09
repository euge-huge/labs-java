package laba9;

import library.Library;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class NewFileDialog extends JDialog {
    public NewFileDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);

        Container container = this.getContentPane();

        JPanel panel = new JPanel();

        JLabel createLibLabel = new JLabel("Введите название библиотеки");
        JTextField enterName = new JTextField();
        JButton createBtn = new JButton("Создать");

        JDialog thisDialog = this;
        createBtn.addActionListener(e -> {
            Library library = new Library(enterName.getText());
            thisDialog.setVisible(false);
            try {
                Laba9.run(library);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
            owner.setVisible(false);
        });

        panel.add(createLibLabel);
        panel.add(enterName);
        panel.add(createBtn);

        panel.setLayout(new GridLayout(0, 1));

        container.add(panel);
        this.pack();
    }
}
