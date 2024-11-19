package me.calebeoliveira.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingFiles {
    public static void main(String[] args) {
        String path = "path/to/file";

        try {
           Stream<String> namesStream = Files.lines(Paths.get(path));

           List<String> names = namesStream.filter(name -> name.startsWith("S")).collect(Collectors.toList());

           names.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
