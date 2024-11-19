package me.calebeoliveira.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsWithCustomObjects {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Chirstie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 500, Type.NOVEL));

        // grouping by type
        Map<Type, List<Book>> booksByType = books.stream()
                        .collect(Collectors.groupingBy(Book::getType));

        booksByType.entrySet().stream().forEach(System.out::println);

        // finding 2 longest books (with more than 500 pages) (number of pages)
        List<String> longestBooks = books.stream().filter(book -> book.getPages() > 500)
                        .map(Book::getTitle).limit(2).collect(Collectors.toList());

        longestBooks.stream().forEach(System.out::println);
    }
}
