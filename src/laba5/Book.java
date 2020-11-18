package laba5;


import java.io.Serializable;

public class Book  extends Edition implements Serializable {
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
            if (this.getAuthor() == null || this.getAuthor().equals("") || this.getName() == null || this.getName().equals("") ) throw new BookException("отсутствует название или автор. Эти поля обязательны.");
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
