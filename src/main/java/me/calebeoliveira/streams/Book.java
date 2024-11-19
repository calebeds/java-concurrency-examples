package me.calebeoliveira.streams;

public class Book {
    private final String author;
    private final String title;
    private final int pages;
    private final Type type;

    public Book(String title, String author, int pages, Type type) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }
}
