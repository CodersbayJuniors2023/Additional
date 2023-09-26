package books;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
       // Book b = new Book("1234", "null", null, null, null, null);

        BookTelescope bt = new BookTelescope("1234", "null", "Drama");

        Book book = new Book.Builder("123-456-789", "Blow")
                .genre("Books")
                .author("some author")
                .published(Year.of(1899))
                .description("""
                        lorem ipsum dolor sit
                        amet
                        """)
                .build();

        System.out.println(book.getTitle() + " " + book.getAuthor());
    }
}
