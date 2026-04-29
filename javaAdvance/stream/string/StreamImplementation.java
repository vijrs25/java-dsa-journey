package javaAdvance.stream.string;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamImplementation {
public static void main(String[] args) {
	List<String> list = List.of("apple", "banana", "kiwi");
	List<Integer> listint = list.stream()
										.map(String :: length)
										.toList();
	for(Integer a: listint) {
		System.out.println(a);
	}
	
	
	
	String a = list.stream()
				.max(Comparator.comparing(String::length))
				.orElse("");
	
	System.out.println(a);
}
}
