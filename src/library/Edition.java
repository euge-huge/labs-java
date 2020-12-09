package library;


import java.io.Serializable;

abstract public class Edition implements Serializable {
    private String name;
    private String author;
    private int year;

    public Edition() {}
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
