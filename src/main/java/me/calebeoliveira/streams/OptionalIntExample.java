package me.calebeoliveira.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class OptionalIntExample {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Chirstie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 500, Type.NOVEL));

        OptionalInt result = books.stream().mapToInt(Book::getPages).max();
        System.out.println(result.orElse(0));

    }
}
