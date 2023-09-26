package books;

import java.time.Year;

public class Book {
    private final String isbn;
    private final String title;

    private final String genre;
    private final String author;
    private final Year published;

    private final String description;


    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.genre = builder.genre;
        this.author = builder.author;
        this.published = builder.published;
        this.description = builder.description;
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

    public static class Builder {
        private final String isbn;
        private final String title;

        private String genre;
        private String author;
        private Year published;

        private String description;


        public Builder(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder published(Year published) {
            this.published = published;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        private void validate() throws IllegalStateException {
            StringBuilder errorMessage = new StringBuilder();

            if (isbn == null) {
                errorMessage.append("ISBN must not be null. ");
            } // else if (check for valid ISBN)

            if (title == null) {
                errorMessage.append("Title must not be null. ");
            } else if (title.length() < 3) {
                errorMessage.append("Title must have at least 3 characters. ");
            }
            // ...
            if (!errorMessage.isEmpty()) {
                throw new IllegalStateException(errorMessage.toString());
            }
        }

        public Book build() {
            validate();
            return new Book(this);
        }
    }
}
