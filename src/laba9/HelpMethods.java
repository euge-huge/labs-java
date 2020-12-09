package laba9;


import library.*;

import java.util.ArrayList;

class HelpMethods {
    //    Получаем объект с данными об изданиях
    static Object[][] getParsedTable(Branch branch) {

        Object[][] data = new Object[branch.getAmountOfEditions()][5];

        for (int i = 0; i < branch.getAmountOfEditions(); i++) {
            ArrayList<Edition> editions = new ArrayList<>(branch.getEditions());
            Edition edition = editions.get(i);
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        if (edition instanceof Catalog) {
                            data[i][j] = "Журнал";
                        }
                        if (edition instanceof Book) {
                            data[i][j] = "Книга";
                        }
                        break;
                    case 1:
                        data[i][j] = edition.getName();
                        break;
                    case 2:
                        data[i][j] = edition.getAuthor();
                        break;
                    case 3:
                        data[i][j] = edition.getYear();
                        break;
                    case 4:
                        if (edition instanceof Catalog) {
                            data[i][j] = ((Catalog) edition).getArticles().toString();
                        }
                        if (edition instanceof Book) {
                            data[i][j] = ((Book) edition).getResume();
                        }
                        break;
                }
            }
        }

        return data;
    }

    //    Получить массив строк названий отделов
    static String[] getNamesOfBranches(Library library) {
        ArrayList<Branch> branches = library.getBranches();
        String[] names = new String[branches.size()];
        for (int i = 0; i < branches.size(); i++) {
            names[i] = branches.get(i).getName();
        }
        return names;
    }

    //    Получить ветку по имени
    static Branch getBranchByName(Library library, String name) {
        ArrayList<Branch> branches = new ArrayList<>(library.getBranches());
        for (Branch branch : branches) {
            if (branch.getName().equals(name)) return branch;
        }
        return branches.get(0);
    }

}
