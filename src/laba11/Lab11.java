package laba11;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab11 {
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
        System.out.print("Введите количество изданий: ");
        amountOfEditions = scan.nextInt();
        scan.nextLine(); /**/

        Branch branch = new Branch(nameOfBranch, amountOfEditions);

        /*Создаем books*/
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

            Book book = new Book(name, author, year, resume);

            editions.add(book);
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

            Catalog catalog = new Catalog(name, author, year, articles);

            editions.add(catalog);
        }


        /* */

        System.out.println("Название библиотеки: " + library.getName());
        System.out.println("Название отдела: " + branch.getName());
        System.out.println("Издания: ");

        for (Edition edition : editions) {
            System.out.println(edition.getDescription());
        }
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

    public Edition (String name, String author, int year) {
        this.name = name;
        this.author = author;
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

    public Book(String name, String author, int year, String resume) {
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
        return "Автор: " + this.getAuthor() +
                "\tГод: " + this.getYear() +
                "\tНазвание: " + this.getName() +
                "\tРезюме: " + this.getResume();
    }
}

class Catalog extends Edition {
    ArrayList<String>  articles = new ArrayList<String>();

    public Catalog(String name, String author, int year, ArrayList<String> articles) {
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
        return "Год: " + this.getYear() +
                "\tНазвание: " + this.getName() +
                "\tСтатьи: " + this.getArticles().toString();
    }
}