package laba1;

import java.util.ArrayList;
import java.util.Scanner;

public class laba1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*Создаем библиотеку*/
        String nameOfLibrary;
        System.out.print("Создайте  библиотеку:\nВведите название: ");
        nameOfLibrary = scan.nextLine();
        Library library = new Library(nameOfLibrary);

        /*Создаем отдел*/
        String nameOfBranch;
        int amountOfEditions;
        System.out.print("Создайте отдел:\nВведите название: ");
        nameOfBranch = scan.nextLine();

        Branch branch = new Branch(nameOfBranch, 0);

        /*Создаем издания*/
        ArrayList<Edition>  editions = new ArrayList<Edition>();
        System.out.print("Введите количество книг: ");
        int countOfBooks = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < countOfBooks; i++) {
            String name;
            String author;
            int year;
            String resume;

            System.out.print("Создайте книгу:\nВведите название: ");
            name = scan.nextLine();
            System.out.print("Введите автора: ");
            author = scan.nextLine();
            System.out.print("Введите год: ");
            year = scan.nextInt();
            scan.nextLine();
            System.out.print("Введите резюме: ");
            resume = scan.nextLine();

            Book book = null;
            try {
                book = new Book(name, author, year, resume);
            } catch (GodIzdaniyaException ex) {
                System.out.print("Потворная обработка ошибки: ");
                System.out.println(ex.getMessage());
            }

            if (book != null) {
                editions.add(book);
            }

        }

        System.out.print("Введите количество журналов: ");
        int countOfCatalog = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < countOfCatalog; i++) {
            String name;
            String author;
            int year;
            ArrayList<String> articles = new ArrayList<String>();

            System.out.print("Создайте журнал:\nВведите название: ");
            name = scan.nextLine();
            System.out.print("Введите автора: ");
            author = scan.nextLine();
            System.out.print("Введите год: ");
            year = scan.nextInt();
            scan.nextLine();
            System.out.print("Введите количество статей: ");
            int countOfArticles = scan.nextInt();
            scan.nextLine();

            for(int j = 0; j < countOfArticles; j++) {
                System.out.print("Введите " + (j+1) + " статью: ");
                String article = scan.nextLine();
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
                editions.add(catalog);
            }
        }


        /* Вывод */

        System.out.println("Название библиотеки: " + library.getName());
        System.out.println("Название отдела: " + branch.getName());
        System.out.println("Издания: ");

        for (Edition edition : editions) {
            System.out.println(edition.getDescription());
        }
    }
}

class BookException extends Exception {
    public BookException(String msg) {
        super(msg);
    }
}

class GodIzdaniyaException extends Exception {
    public GodIzdaniyaException(String msg) {
        super(msg);
    }
}

class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Branch {
    private String name;
    private int amountOfEdition;

    public Branch(String name, int amountOfEdition) {
        this.name = name;
        this.amountOfEdition = amountOfEdition;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfEdition() {
        return amountOfEdition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOfEdition(int amountOfEdition) {
        this.amountOfEdition = amountOfEdition;
    }
}

abstract class Edition {
    private String name;
    private String author;
    private int year;

    public Edition (String name, String author, int year) throws GodIzdaniyaException {
        this.name = name;
        this.author = author;
        try {
            if (year <= 0) throw new GodIzdaniyaException("Невозможно создать издание – указан некорректный год издания: " + year);
        } catch (GodIzdaniyaException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract String getDescription();
}

class Book extends Edition {
    private String resume;

    public Book(String name, String author, int year, String resume) throws GodIzdaniyaException {
        super(name, author, year);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


    public String getDescription() {
        try {
            if (this.getAuthor().equals(null) || this.getAuthor().equals("") || this.getName().equals(null) || this.getName().equals("") ) throw new BookException("отсутствует название или автор. Эти поля обязательны.");
        } catch (BookException ex) {
            ex.printStackTrace();
            return "Ошибка: " + ex.getMessage();
        }
        return "Автор: " + this.getAuthor() +
                "\tГод: " + this.getYear() +
                "\tНазвание: " + this.getName() +
                "\tРезюме: " + this.getResume();

    }
}

class Catalog extends Edition {
    ArrayList<String> articles = new ArrayList<String>();

    public Catalog(String name, String author, int year, ArrayList<String> articles) throws GodIzdaniyaException  {
        super(name, author, year);
        this.articles = articles;
    }

    public ArrayList<String> getArticles() {
        return articles;
    }

    public void addArticle(String article) {
        articles.add(article);
    }

    public String getDescription() {
        try {
            if (this.getAuthor().equals(null) || this.getAuthor().equals("") || this.getName().equals(null) || this.getName().equals("") ) throw new BookException("отсутствует название или автор. Эти поля обязательны.");
        } catch (BookException ex) {
             return "Ошибка: " + ex.getMessage();
        }

        return "Год: " + this.getYear() +
                "\tНазвание: " + this.getName() +
                "\tСтатьи: " + this.getArticles().toString();
    }
}




