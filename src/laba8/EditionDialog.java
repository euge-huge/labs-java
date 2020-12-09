package laba8;

import laba9.EditionTableModel;
import library.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EditionDialog extends JDialog {
    public EditionDialog(Frame owner, String title, boolean modal, JLabel amount, Branch currentBranch, JTable table)  {
        super(owner, title, modal);

        Container container = this.getContentPane();

        JPanel panel = new JPanel();
        String[] types = {"Книга", "Журнал"};

        JLabel enterTypeLabel = new JLabel("Выберите тип издания: ");
        JList listOfTypes = new JList(types);
        listOfTypes.setSelectedIndex(0);


        JLabel enterNameLabel = new JLabel("Введите название: ");
        JTextField nameTextField = new JTextField();

        JLabel enterAuthorLabel = new JLabel("Введите автора: ");
        JTextField authorTextField = new JTextField();

        JLabel enterYearLabel = new JLabel("Введите год: ");
        JTextField yearTextField = new JTextField();

        JLabel enterResumeLabel = new JLabel("Введите резюме (книга): ");
        JTextField resumeTextField = new JTextField();

        JLabel enterArticlesLabel = new JLabel("Введите статьи через запятую (журнал) : ");
        JTextField articlesTextField = new JTextField();
        articlesTextField.setEnabled(false);


        JButton button = new JButton("Создать");
        button.addActionListener(e -> {
            if (listOfTypes.getSelectedValue().equals("Книга")) {
                Book book = null;
                try {
                    book = new Book(nameTextField.getText(), authorTextField.getText(), Integer.parseInt(yearTextField.getText()), resumeTextField.getText());
                } catch (GodIzdaniyaException godIzdaniyaException) {
                    godIzdaniyaException.printStackTrace();
                }
                currentBranch.addEdition(book);
            } else {
                String articles = articlesTextField.getText();
                ArrayList<String> splitArticles = new ArrayList<>(Arrays.asList(articles.split(",")));

                Catalog catalog = null;
                try {
                    catalog = new Catalog(nameTextField.getText(), authorTextField.getText(), Integer.parseInt(yearTextField.getText()), splitArticles);
                } catch (GodIzdaniyaException godIzdaniyaException) {
                    godIzdaniyaException.printStackTrace();
                }
                currentBranch.addEdition(catalog);

            }
            table.setModel(new EditionTableModel(currentBranch));
            amount.setText(String.valueOf(currentBranch.getAmountOfEditions()));
        });

        listOfTypes.addListSelectionListener(e -> {
            if (listOfTypes.getSelectedValue().equals("Журнал")) {
                resumeTextField.setEnabled(false);
                articlesTextField.setEnabled(true);
            }
            else {
                resumeTextField.setEnabled(true);
                articlesTextField.setEnabled(false);
            }
        });

        panel.add(enterTypeLabel);
        panel.add(listOfTypes);

        panel.add(enterNameLabel);
        panel.add(nameTextField);

        panel.add(enterAuthorLabel);
        panel.add(authorTextField);

        panel.add(enterYearLabel);
        panel.add(yearTextField);

        panel.add(enterResumeLabel);
        panel.add(resumeTextField);

        panel.add(enterArticlesLabel);
        panel.add(articlesTextField);

        panel.add(button);

        panel.setLayout(new GridLayout(0, 1));

        container.add(panel);
        this.pack();
    }
}
