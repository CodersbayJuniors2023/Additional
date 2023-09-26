package books;

import java.time.Year;
/*
    Telescope constructor pattern
 */
public class BookTelescope {
    private final String isbn;
    private final String title;

    private final String genre;
    private final String author;
    private final Year published;

    private final String description;


    public BookTelescope(String isbn, String title) {
        this(isbn, title, null);
    }

    public BookTelescope(String isbn, String title, String genre) {
        this(isbn, title, genre, null);
    }

    public BookTelescope(String isbn, String title, String genre, String author) {
        this(isbn, title, genre, author, null);
    }

    public BookTelescope(String isbn, String title, String genre, String author, Year published) {
        this(isbn, title, genre, author, published, null);
    }


    public BookTelescope(String isbn, String title, String genre, String author, Year published, String description) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.published = published;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public Year getPublished() {
        return published;
    }

    public String getDescription() {
        return description;
    }
}
