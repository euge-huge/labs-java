package laba8;

import library.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static laba8.HelpMethods.getNamesOfBranches;

public class EditionDialog extends JDialog {
    public EditionDialog(Frame owner, String title, boolean modal, JLabel amount, Branch currentBranch, JTable table)  {
        super(owner, title, modal);

        Container container = this.getContentPane();

        JPanel panel = new JPanel();
        String[] types = {"Книга", "Журнал"};

        JLabel label = new JLabel("Выберите тип издания: ");
        JList list = new JList(types);
        list.setSelectedIndex(0);


        JLabel label1 = new JLabel("Введите название: ");
        JTextField textField = new JTextField();

        JLabel label2 = new JLabel("Введите автора: ");
        JTextField textField2 = new JTextField();

        JLabel label3 = new JLabel("Введите год: ");
        JTextField textField3 = new JTextField();

        JLabel label4 = new JLabel("Введите резюме (книга): ");
        JTextField textField4 = new JTextField();

        JLabel label5 = new JLabel("Введите статьи через запятую (журнал) : ");
        JTextField textField5 = new JTextField();
        textField5.setEnabled(false);


        JButton button = new JButton("Создать");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedValue().equals("Книга")) {
                    Book book = null;
                    try {
                        book = new Book(textField.getText(), textField2.getText(), Integer.parseInt(textField3.getText()), textField4.getText());
                    } catch (GodIzdaniyaException godIzdaniyaException) {
                        godIzdaniyaException.printStackTrace();
                    }

                    currentBranch.addEdition(book);
                } else {
                    String articles = textField5.getText();
                    ArrayList<String> splitArticles = new ArrayList<String>(Arrays.asList(articles.split(",")));

                    Catalog catalog = null;
                    try {
                        catalog = new Catalog(textField.getText(), textField2.getText(), Integer.parseInt(textField3.getText()), splitArticles);
                    } catch (GodIzdaniyaException godIzdaniyaException) {
                        godIzdaniyaException.printStackTrace();
                    }
                    currentBranch.addEdition(catalog);

                }

                table.setModel(new EditionTableModel(currentBranch));
                amount.setText(String.valueOf(currentBranch.getAmountOfEditions()));
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedValue().equals("Журнал")) {
                    textField4.setEnabled(false);
                    textField5.setEnabled(true);
                }
                else {
                    textField4.setEnabled(true);
                    textField5.setEnabled(false);
                }
            }
        });


        panel.add(label);
        panel.add(list);

        panel.add(label1);
        panel.add(textField);

        panel.add(label2);
        panel.add(textField2);

        panel.add(label3);
        panel.add(textField3);

        panel.add(label4);
        panel.add(textField4);

        panel.add(label5);
        panel.add(textField5);

        panel.add(button);

        panel.setLayout(new GridLayout(0, 2));
        container.add(panel);
        this.pack();
    }
}
