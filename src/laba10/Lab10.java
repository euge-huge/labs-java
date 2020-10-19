package laba10;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*Создаем библиотеку*/
        String nameOfLibrary;
        System.out.print("Создайте библиотеку:\nВведите название: ");
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

        /*Создаем издание*/
        String nameOfEdition;
        String authorOfEdition;
        int yearOfEdition;

        System.out.print("Создайте издание:\nВведите название: ");
        nameOfEdition = scan.nextLine();
        System.out.print("Введите автора: ");
        authorOfEdition = scan.nextLine();
        System.out.print("Введите год издания: ");
        yearOfEdition = scan.nextInt();
        scan.nextLine(); /**/

        Edition edition = new Edition(nameOfEdition, authorOfEdition, yearOfEdition);

        /*Создаем книгу*/
        String nameOfBook;
        String authorOfBook;
        int yearOfBook;
        String resume;

        System.out.print("Создайте книгу:\nВведите название: ");
        nameOfBook = scan.nextLine();
        System.out.print("Введите автора: ");
        authorOfBook = scan.nextLine();
        System.out.print("Введите год издания книги: ");
        yearOfBook = scan.nextInt();
        scan.nextLine(); /**/
        System.out.print("Введите резюме: ");
        resume = scan.nextLine();

        Book book = new Book(nameOfBook, authorOfBook, yearOfBook, resume);

        /*Создаем журнал*/
        String nameOfCatalog;
        String authorOfCatalog;
        int yearOfCatalog;
        ArrayList<String> articlesOfCatalog = new ArrayList<String>();

        System.out.print("Создайте журнал:\nВведите название: ");
        nameOfBook = scan.nextLine();
        System.out.print("Введите автора: ");
        authorOfBook = scan.nextLine();
        System.out.print("Введите год издания книги: ");
        yearOfBook = scan.nextInt();
        scan.nextLine(); /**/
        System.out.print("Введите количетсво статей: ");
        int amount = scan.nextInt();
        scan.nextLine(); /**/
        for(int i = 0; i < amount; i++) {
            String article;
            System.out.print("Введите "+ (i+1) + " статью: ");
            article = scan.nextLine();

            articlesOfCatalog.add(article);
        }

        Catalog catalog = new Catalog(nameOfBook, authorOfBook, yearOfBook, articlesOfCatalog);

        /*Вывод результата*/
        System.out.println("\n\nВы создали: ");

        System.out.println("Библиотеку:\nНазвание: " + library.getName() + "\n");
        System.out.println("Отдел:\nНазвание: " + branch.getName() +
                ", Количество изданий: " + branch.getAmountOfEditions() + "\n");
        System.out.println("Издание:\n" + edition.getDescription() + "\n");
        System.out.println("Книгу:\n" + book.getDescription() + "\n");
        System.out.println("Журнал:\n" + catalog.getDescription() + "\n");
    }

}

class Library {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library(String name) {
        this.name = name;
    }
}

class Branch {
    private String name;
    private int amountOfEditions;

    public String getName() {
        return name;
    }

    public int getAmountOfEditions() {
        return amountOfEditions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOfEditions(int amountOfEditions) {
        this.amountOfEditions = amountOfEditions;
    }

    public Branch(String name, int amountOfEditions) {
        this.name = name;
        this.amountOfEditions = amountOfEditions;
    }
}

class Edition {
    private String name;
    private String author;
    private int year;


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

    public String getDescription() {
        return "Название издания: " + this.name + ", автор: " + this.author +
                ", год: " + this.year + ".";
    }

    public Edition(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
}

class Book extends Edition {
    private String resume;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String getDescription() {
        return "Название книги: " + super.getName() + ", автор: " + super.getAuthor() +
                ", год: " + this.getYear() + ", резюме: " + this.resume;
    }

    public Book(String name, String author, int year, String resume) {
        super(name, author, year);
        this.resume = resume;
    }
}

class Catalog extends Edition {
    ArrayList<String> articles = new ArrayList<String>();

    public ArrayList<String> getArticles() {
        return articles;
    }

    public void addArticle(String article) {
        articles.add(article);
    }

    @Override
    public String getDescription() {
        return "Название журнала: " + super.getName() + ", автор: " + super.getAuthor() +
                ", год: " + this.getYear() + ", статьи: " + this.articles.toString();
    }

    public Catalog(String name, String author, int year, ArrayList<String> articles) {
        super(name, author, year);
        this.articles = articles;
    }
}
