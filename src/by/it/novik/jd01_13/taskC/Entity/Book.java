package by.it.novik.jd01_13.taskC.Entity;

/**
 * Created by Kate Novik.
 */
public class Book extends Things {
    // Поле ISBN книги
    private String isbnBook;
    // Поле автор
    private String author;

    public Book () {
        super();
        this.isbnBook = null;
        this.author = null;
    }

    public Book (String isbnBook, String author, String name) {
        super.setName(name);
        this.isbnBook = isbnBook;
        this.author = author;
    }

    public void setISBNBook (String isbnBook) {
        this.isbnBook = isbnBook;
    }

    public String getISBNBook () {
        return isbnBook;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public String getAuthor () {
        return author;
    }
}
