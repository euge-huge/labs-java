package laba9;

import laba8.ListOfBranchesModel;
import library.Branch;
import library.Library;
import library.WriteAndReadLibraryXML;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.IOException;

import static laba9.HelpMethods.getBranchByName;
import static laba9.HelpMethods.getNamesOfBranches;


public class Laba9GUI extends JFrame {
    //    Загружаем библиотеку в приложение
    Library library;

    //    Отдел пока не выбран
    Branch currentBranch = null;

    //    Панель закладок
    JTabbedPane pane = new JTabbedPane();

    //    Создаем панели-закладки
    JPanel infAboutBranch = new JPanel();
    JPanel editions = new JPanel();

    //    Панель "Информация об отделе"
    JLabel infChooseLabel = new JLabel("Выберите отдел для отчета: ");
    ListOfBranchesModel listOfBranchesModel;
    JList<String> listOfBranches = new JList<>();
    JScrollPane scrollPane = new JScrollPane(listOfBranches);
    JLabel amountOfEdLabel = new JLabel("Количество изданий в нем: ");
    JLabel amountOfEdition = new JLabel("-");

    //    Панель "Издания"

//    //    Создаем модель таблицы на основе текущего отдела
    EditionTableModel editionTableModel = new EditionTableModel(currentBranch);

    // Создаем таблицу
    JTable table = new JTable(editionTableModel);
    JScrollPane tableScrollPane = new JScrollPane(table);

    // Кнопка
    JButton button = new JButton("Сформировать описание");
    GetDescriptionBtnClick descBtnListen;


    public Laba9GUI(Library library) {
        this.library = library;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();

        if (library != null) {
            this.setTitle(library.getName());
            listOfBranchesModel = new ListOfBranchesModel(getNamesOfBranches(library));
            listOfBranches.setModel(listOfBranchesModel);
        } else {
            this.setTitle("Система управления библиотекой");
        }

//        Панель Информации об отделе
        infAboutBranch.add(infChooseLabel);
        infAboutBranch.add(scrollPane);
        infAboutBranch.add(amountOfEdLabel);
        infAboutBranch.add(amountOfEdition);

        listOfBranches.setLayoutOrientation(JList.VERTICAL);
        listOfBranches.addListSelectionListener(new SelectListListener());

        infAboutBranch.setLayout(new GridLayout(0, 2));


////        Панель информции об изданиях отдела
        editions.add(tableScrollPane);
        editions.add(button);

        if(currentBranch == null) button.setEnabled(false);

        descBtnListen = new GetDescriptionBtnClick(table, currentBranch);
        button.addActionListener(descBtnListen);

        editions.setLayout(new GridLayout(0, 1));

//        Добавляем панели
        pane.add(infAboutBranch, "Информация об отделе");
        pane.add(editions, "Издания");

        if (library == null) pane.setEnabled(false);


        // Добавляем всю общую панель в контейнер
        container.add(pane);
    }




    class SelectListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            currentBranch = getBranchByName(library, listOfBranches.getSelectedValue());
            amountOfEdition.setText(String.valueOf(getBranchByName(library, listOfBranches.getSelectedValue()).getAmountOfEditions()));
            editionTableModel = new EditionTableModel(getBranchByName(library, listOfBranches.getSelectedValue()));
            table.setModel(editionTableModel);

            button.setEnabled(true);
            button.removeActionListener(descBtnListen);
            descBtnListen = new GetDescriptionBtnClick(table, currentBranch);
            button.addActionListener(descBtnListen);
        }
    }



    protected void showMenu(boolean showMenu) {
        //create a menu bar
        final JMenuBar menuBar = new JMenuBar();

        Laba9GUI owner = this;

        JMenu fileMenu = new JMenu("Файл");

        JMenuItem createFile = new JMenuItem("Новый");
        createFile.addActionListener(e -> {
            JDialog dialog = new NewFileDialog(owner, "Создайте библиотеку", true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
        JMenuItem openFile = new JMenuItem("Открыть");
        openFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.showOpenDialog(null);
            Library library = null;
            try {
                library = WriteAndReadLibraryXML.read(fileChooser.getSelectedFile().getPath());
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }

            try {
                Laba9.run(library);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }

            owner.setVisible(false);

        });

        JMenuItem saveFile = new JMenuItem("Сохранить");
        if(library == null) saveFile.setEnabled(false);
        saveFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int chooser = fileChooser.showSaveDialog(null);
            if (chooser == JFileChooser.APPROVE_OPTION) {
                try {
                    WriteAndReadLibraryXML.write(library, fileChooser.getSelectedFile()+".xml");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        fileMenu.add(createFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        //create menus
        JMenu createMenu = new JMenu("Создать");

        //create menu items
        JMenuItem createBranch = new JMenuItem("Отдел");

        createBranch.addActionListener(e -> {
            JDialog dialog = new BranchDialog(owner, "Создать отдел", true, library, listOfBranches);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
//
        JMenuItem createEdition = new JMenuItem("Издание");
        createEdition.addActionListener(e -> {
            JDialog dialog = new EditionDialog(owner, "Создать издание", true, amountOfEdition, currentBranch, table);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });


        //add menu items to menus
        createMenu.add(createBranch);
        createMenu.add(createEdition);

        createMenu.setEnabled(showMenu);


        //add menu to menubar
        menuBar.add(fileMenu);
        menuBar.add(createMenu);

        //add menubar to the frame
        setJMenuBar(menuBar);
    }

}