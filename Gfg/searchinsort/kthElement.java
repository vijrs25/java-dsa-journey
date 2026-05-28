package searchinsort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class kthElement {

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 7, 9 };
		int b[] = { 1, 4, 8, 10 };
		int k = 5;
		int count =0;
	    Set<Integer> i = new TreeSet<>();
	
	    for (int j = 0; j < a.length; j++) {
	    		i.add(a[j]);	
		}
	    for (int j = 0; j < b.length; j++) {
	    	    i.add(b[j]);
		}
	    
	  for(Integer k1 : i) {
		  count++;
	      if(count>5) break;
	    System.out.println(k1);}
	}
}
