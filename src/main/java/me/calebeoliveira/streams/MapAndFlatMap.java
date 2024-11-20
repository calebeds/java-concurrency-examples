package me.calebeoliveira.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {
    public static void main(String[] args) {

        // map() and flatMap() are similar to selecting a column in SQL
        // transform the original values
        // number of characters in every word
        List<String> words = Arrays.asList("Adam", "Ana", "Daniel");
        List<Integer> lengths = words.stream().map(String::length).collect(Collectors.toList());
//        lengths.forEach(System.out::println);

        // create a list containing the squared values
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        List<Integer> squaredNums = nums.stream().map(num -> num * num).collect(Collectors.toList());
//        squaredNums.forEach(System.out::println);

        // flatMap() - mapping each array not with a stream but with
        // the contents of that stream
        // [[1, 3, 5], [5, 13]] -> [1, 3, 5, 5, 13]
        // "hello" "shell" - get all the unique characters (h, e, l, o, s)
        String[] array = {"hello", "shell"};
        List<String> unique = Arrays.stream(array).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        unique.forEach(System.out::println);
    }
}
