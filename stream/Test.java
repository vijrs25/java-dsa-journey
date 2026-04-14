package stream;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
public static void main(String[] args) {
	 String text1 = "Prtottrogramming";
	 
	 Map<Character, Long> mp = text1.chars()
			 		.mapToObj(c -> (char) c)
			 		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
			 				    Collectors.counting() ));
			 		
	 for(Entry<Character, Long> ch :  mp.entrySet()) {
		 System.out.println(ch.getKey()+" "+ch.getValue()); 
	 }
	 
	 
	 Character firstNonRepeated = text1.chars()
			 .mapToObj(c -> (char) c)
			 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting() 
					       ))
			 .entrySet()
			 .stream()
			 .filter(entry -> entry.getValue() == 1)
			 .map(Map.Entry::getKey)
             .findFirst()
             .orElse(null);
	 
	 System.out.println(firstNonRepeated);
}
}
