package streamOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntermediate {
	/*
	Find total length of all strings
	Find max number in list
	Find longest string
	Remove duplicates from list
	Sort strings by length
	Sort integers descending
	Get average of numbers
	Find second highest number
	Get first 3 elements (limit())
	Skip first 2 elements (skip())
	*/
	public static void main(String[] args) {
		List<String> names = List.of("ram", "shyam", "mohan","christopher","proffessor","mohan");
		String[] a =  names.toArray(new String[0]);
		
		for (String string : a) {
			System.out.println(string);
		}
		// A
		System.out.println(Arrays.stream(a)
									.collect(Collectors.summingInt(String :: length))
				);
		//B
		System.out.println(Arrays.stream(a).mapToInt(String::length).sum());
		System.out.println(Arrays.stream(a).mapToDouble(String::length).average().getAsDouble());
		System.out.println(Arrays.stream(a).collect(Collectors.averagingInt(String::length)));
		
		System.out.println(Arrays.stream(a).mapToInt(str -> str.length()).max());
		System.out.println(Arrays.stream(a).collect(Collectors.reducing("", (c,b) -> c.length()>b.length()?c:b)));
		
		System.out.println(Arrays.stream(a).distinct().toList());
		
		System.out.println(Arrays.stream(a).sorted(Comparator.comparing(String::length).reversed()).toList());
		System.out.println(Arrays.stream(a).sorted(Comparator.comparing(String::length)).toList());
		
		System.out.println(Arrays.stream(a).sorted(Comparator.comparing(String::length).reversed()).limit(2)
				.max(Comparator.comparing(String::length).reversed()));
		
		
		System.out.println(
			    Arrays.stream(a)
			          .sorted(Comparator.comparing(String::length).reversed())
			          .skip(2)
			          .findFirst()
			          .orElse("")
			);
		
		System.out.println(Arrays.stream(a).sorted(Comparator.comparing(String::length).reversed()).limit(3).toList());
	}

}
