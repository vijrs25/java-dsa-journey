package streamOutput;

import java.util.Arrays;
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
		List<String> names = List.of("ram", "shyam", "mohan ","christopher","proffessor","mohan");
		String[] a =  names.toArray(new String[0]);
		
		for (String string : a) {
			System.out.println(string);
		}
		
		System.out.println(Arrays.stream(a)
									.collect(Collectors.groupingBy(String :: length))
				);
		
		
	}

}
