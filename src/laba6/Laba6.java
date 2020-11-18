package laba6;

import java.io.IOException;
import java.util.ArrayList;

public class Laba6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Создаем библиотеку*/
        String nameOfLibrary;
        System.out.print("Создайте  библиотеку:\nВведите название: ");
        nameOfLibrary = InputByKeyboard.readString();
        Library library = new Library(nameOfLibrary);

        System.out.print("Введите количество отделов: ");
        int amountOfBranches = InputByKeyboard.readInteger();
        for (int i=0; i < amountOfBranches; i++) {
            /*Создаем отдел*/
            String nameOfBranch;
            System.out.print("Создайте отдел:\nВведите название: ");
            nameOfBranch = InputByKeyboard.readString();

            Branch branch = new Branch(nameOfBranch);

            System.out.print("Введите количество книг: ");
            int countOfBooks = InputByKeyboard.readInteger();

            for(int j = 0; j < countOfBooks; j++) {
                String name;
                String author;
                int year;
                String resume;

                System.out.print("Создайте книгу:\nВведите название: ");
                name = InputByKeyboard.readString();
                System.out.print("Введите автора: ");
                author = InputByKeyboard.readString();
                System.out.print("Введите год: ");
                year = InputByKeyboard.readInteger();
                System.out.print("Введите резюме: ");
                resume = InputByKeyboard.readString();

                Book book = null;
                try {
                    book = new Book(name, author, year, resume);
                } catch (GodIzdaniyaException ex) {
                    System.out.print("Потворная обработка ошибки: ");
                    System.out.println(ex.getMessage());
                }

                if (book != null) {
                    branch.addEdition(book);
                }

            }

            System.out.print("Введите количество журналов: ");
            int countOfCatalog = InputByKeyboard.readInteger();

            for(int j = 0; j < countOfCatalog; j++) {
                String name;
                String author;
                int year;
                ArrayList<String> articles = new ArrayList<>();

                System.out.print("Создайте журнал:\nВведите название: ");
                name = InputByKeyboard.readString();
                System.out.print("Введите автора: ");
                author = InputByKeyboard.readString();
                System.out.print("Введите год: ");
                year = InputByKeyboard.readInteger();
                System.out.print("Введите количество статей: ");
                int countOfArticles = InputByKeyboard.readInteger();

                for(int k = 0; k < countOfArticles; k++) {
                    System.out.print("Введите " + (j+1) + " статью: ");
                    String article = InputByKeyboard.readString();
                    articles.add(article);
                }

                Catalog catalog = null;
                try {
                    catalog = new Catalog(name, author, year, articles);
                } catch (GodIzdaniyaException ex) {
                    System.out.print("Потворная обработка ошибки: ");
                    System.out.println(ex.getMessage());
                }

                if(catalog != null) {
                    branch.addEdition(catalog);
                }
            }

            library.addBranch(branch);
        }

        WriteAndReadLibraryXML.write(library, "library.xml");

        Library readLibrary = WriteAndReadLibraryXML.read("library.xml");

        System.out.println("\nБиблиотеки: " + readLibrary.getName());
        System.out.println("\tОтделы:");
        ArrayList<Branch> branches = readLibrary.getBranches();
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            System.out.println( "\t" + (i+1) + ". Отдел: " + branch.getName());
            System.out.println("\t\tИздания:");
            ArrayList<Edition> editions = branch.getEditions();
            for (Edition edition : editions) {
                System.out.println("\t\t * " + edition.getDescription());
            }
        }

    }
}
