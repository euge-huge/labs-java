package laba5;


import java.io.Serializable;
import java.util.ArrayList;

public class Catalog extends Edition implements Serializable {
    ArrayList<String> articles;

    public Catalog(String name, String author, int year, ArrayList<String> articles) throws GodIzdaniyaException {
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
            if (this.getAuthor() == null || this.getAuthor().equals("") || this.getName() == null || this.getName().equals("") ) throw new BookException("отсутствует название или автор. Эти поля обязательны.");
        } catch (BookException ex) {
            return "Ошибка: " + ex.getMessage();
        }

        return "Год: " + this.getYear() +
                "\tНазвание: " + this.getName() +
                "\tСтатьи: " + this.getArticles().toString();
    }
}
