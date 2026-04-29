package javaAdvance.stream.string;

import java.util.List;

public class StreamBasic {

	public static void main(String[] args) {
		/*List of strings → convert to uppercase
		List of strings → get lengths (List<Integer>)
		List of integers → square each number
		List of integers → filter even numbers
		List of strings → filter strings length > 3
		List of strings → trim all strings
		List of strings → convert to lowercase
		List of integers → remove negative numbers
		List of strings → append "!" to each string
		Count how many strings have length > 4 (count())
		*/
		List<String> names = List.of("ram", "shyam", "mohan ", "r am ","christopher","proffessor");
		System.out.println(names.stream().map(str -> str.toUpperCase()).toList());
		
		System.out.println(names.stream().map(str -> str.length()).toList());
		
		System.out.println(names.stream().map(str -> str.length()).map(x -> x*x).toList());
		
		System.out.println(names.stream().map(str -> str.length()).filter(x -> x%2 != 0).toList());
		
		System.out.println(names.stream().map(str -> str.length()).filter(x -> x>3 ).toList());
		
		System.out.println(names.stream().map(str -> str.trim()).toList());
		
		System.out.println(names.stream().map(str -> new String().concat("!")+str).toList());
		
		System.out.println(names.stream().map(str -> str.replace(" ", "")).toList());
		
		System.out.println(names.stream().map(str -> str.length()).filter(x ->x>4).count());
	}

}
