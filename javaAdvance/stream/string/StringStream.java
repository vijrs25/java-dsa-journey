package javaAdvance.stream.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStream {

    public static void main(String[] args) {

        // 1. Duplicate character count
        System.out.println("1. Duplicate character count");
        String text1 = "Prtottrogramming";

        Map<Character, Long> charCountMap = text1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Full character frequency map:");
        System.out.println(charCountMap);

        System.out.println("Repeated characters only:");
        charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        System.out.println("--------------------------------------------------");

        // 2. First non-repeated character
        System.out.println("2. First non-repeated character");
        String text2 = "pprroogramming";

        Character firstNonRepeated = text2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("Input String: " + text2);
        System.out.println("First non-repeated character: " + firstNonRepeated);

        System.out.println("--------------------------------------------------");

        // 3. String -> length map and sorting
        System.out.println("3. String to length map and sorting");
        String[] words = { "Java", "SpringBoot", "APIaweawe", "Kafka" };

        System.out.println("Sorted by key (alphabetically):");
        Arrays.stream(words)
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        System.out.println();

        System.out.println("Sorted by value (length):");
        Arrays.stream(words)
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        System.out.println("--------------------------------------------------");

        // 4. Remove duplicates from int array
        System.out.println("4. Remove duplicates from int array");
        int[] numbers1 = { 1, 2, 2, 3, 4, 55, 6, 6, 7 };

        Arrays.stream(numbers1)
                .distinct()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("--------------------------------------------------");

        // 5. Square of even numbers
        System.out.println("5. Square of even numbers");
        int[] numbers2 = { 1, 2, 2, 3, 4, 55, 6, 6, 7 };

        Arrays.stream(numbers2)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("--------------------------------------------------");

        // 6. Sort String array by length
        System.out.println("6. Sort String array by length");
        String[] words2 = { "Java", "SpringBoot", "API", "Kafka" };

        System.out.println("Method 1: Manual comparator (descending by length)");
        Arrays.stream(words2)
                .sorted((x, y) -> Integer.compare(y.length(), x.length()))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Method 2: Comparator.comparing (ascending by length)");
        Arrays.stream(words2)
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Method 3: Comparator.comparing + reversed (descending by length)");
        Arrays.stream(words2)
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);

        System.out.println("--------------------------------------------------");
    }
}