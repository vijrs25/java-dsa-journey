import java.util.HashMap;
import java.util.Map.Entry;

public class Test2 {
	public static void main(String[] args) {
		String s = "abcddddefghsshhhab";
		//output:  everything 1 , d = 4 , s = 2
	  HashMap<Character, Integer> m = new HashMap<>();

	  for(int i = 0 ; i < s.length(); i++) {
		  if(!m.containsKey(s.charAt(i))) {
			  m.put(s.charAt(i), 0);
		  } 
		  m.put(s.charAt(i), m.get(s.charAt(i))+1);
	  }
	  
	  for(Entry<Character, Integer> enter : m.entrySet())
	  {
		    if(enter.getValue()>1) {
		    	System.out.println(enter.getKey()+" "+enter.getValue());
		    }
	  }
	  
}}
