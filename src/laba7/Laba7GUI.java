package laba7;

import library.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

import static laba7.HelpMethods.*;

public class Laba7GUI extends JFrame {
    //    Загружаем библиотеку в приложение
    Library library = WriteAndReadLibraryXML.read("library.xml");
    //    Выбираем как текущий первый отдел
    Branch currentBranch = library.getBranches().get(0);

    //    Панель закладок
    JTabbedPane pane = new JTabbedPane();

    //    Создаем панели-закладки
    JPanel infAboutBranch = new JPanel();
    JPanel editions = new JPanel();

    //    Панель "Информация об отделе"
    JLabel infChooseLabel = new JLabel("Выберите отдел для отчета: ");
    JList<String> listOfBranches = new JList<>(getNamesOfBranches(library));
    JScrollPane scrollPane = new JScrollPane(listOfBranches);
    JLabel amountOfEdLabel = new JLabel("Количество изданий в нем: ");
    JLabel amountOfEdition = new JLabel();

    //    Панель "Издания"

    //    Загаловки для будущей таблицы
    String[] columnNames = {"Вид издания",
            "Название",
            "Автор",
            "Год издания",
            "Дополнительно"};
    //    Создаем модель таблицы на основе текущего отдела
    EditionTableModel editionTableModel = new EditionTableModel(currentBranch, columnNames);

    // Создаем таблицу
    JTable table = new JTable(editionTableModel);
    JScrollPane tableScrollPane = new JScrollPane(table);

    // Кнопка
    JButton button = new JButton("Сформировать описание");
    GetDescriptionBtnClick descBtnListen;


    public Laba7GUI() throws IOException, ClassNotFoundException {
        super("Laba 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();

//        Панель Информации об отделе
        infAboutBranch.add(infChooseLabel);
        infAboutBranch.add(scrollPane);
        infAboutBranch.add(amountOfEdLabel);
        infAboutBranch.add(amountOfEdition);

        listOfBranches.setLayoutOrientation(JList.VERTICAL);
        listOfBranches.setSelectedIndex(0);
        listOfBranches.addListSelectionListener(new SelectListListener());

        amountOfEdition.setText(String.valueOf(getBranchByName(library, listOfBranches.getSelectedValue().toString()).getAmountOfEditions()));

        infAboutBranch.setLayout(new GridLayout(0, 2));


//        Панель информции об изданиях отдела
        editions.add(tableScrollPane);
        editions.add(button);

        descBtnListen = new GetDescriptionBtnClick(table, currentBranch);
        button.addActionListener(descBtnListen);


        editions.setLayout(new GridLayout(0, 1));

//        Добавляем панели
        pane.add(infAboutBranch, "Информация об отделе");
        pane.add(editions, "Издания");

        // Добавляем всю общую панель в контейнер
        container.add(pane);
    }


    class SelectListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            currentBranch = getBranchByName(library, listOfBranches.getSelectedValue());
            amountOfEdition.setText(String.valueOf(getBranchByName(library, listOfBranches.getSelectedValue()).getAmountOfEditions()));
            editionTableModel = new EditionTableModel(getBranchByName(library, listOfBranches.getSelectedValue()), columnNames);
            table.setModel(editionTableModel);
            button.removeActionListener(descBtnListen);
            descBtnListen = new GetDescriptionBtnClick(table, currentBranch);
            button.addActionListener(descBtnListen);
        }
    };

}