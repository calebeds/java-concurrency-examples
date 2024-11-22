package me.calebeoliveira.streams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelSaveOperation {
    public static final String DIRECTORY = System.getProperty("user.dir") + "/test/";

    public static void main(String[] args) throws IOException {
        // create the directory
        Files.createDirectories(Paths.get(DIRECTORY));

        ParallelSaveOperation app = new ParallelSaveOperation();

        // generate a large number of Person Objects
        List<Person> people = app.generatePeople(100_000);

        // sequential algorithm
        long start = System.currentTimeMillis();
        people.stream().forEach(ParallelSaveOperation::save);
        System.out.println("Time taken sequential: " + (System.currentTimeMillis() - start));

        // parallel algorithm
        start = System.currentTimeMillis();
        people.parallelStream().forEach(ParallelSaveOperation::save);
        System.out.println("Time taken parallel: " + (System.currentTimeMillis() - start));
    }

    private static void save(Person person) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(DIRECTORY + person.getPersonId() + ".txt")) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Person> generatePeople(int num) {
        return Stream.iterate(0, n -> n +1).limit(num).map(Person::new).collect(Collectors.toList());
    }
}
