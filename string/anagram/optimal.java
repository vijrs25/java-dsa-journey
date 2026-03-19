package string.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class optimal {

	    static final int MAX_CHAR = 256;

	    // Function to generate hash of word s
	    static String getHash(String s) {
	        StringBuilder hash = new StringBuilder();
	        int[] freq = new int[MAX_CHAR];
	        
	        // Count frequency of each character
	        for (char ch : s.toCharArray()) {
	            freq[ch]++;
	            System.out.println(ch+" "+" "+freq[ch]);
	            
	        }

	        // Append the frequency to construct the hash
	        for (int i = 0; i < MAX_CHAR; i++) {
	            hash.append(freq[i]);
	            hash.append("$");
	        }
	        System.out.println(hash);
	        return hash.toString();
	    }

	    static ArrayList<ArrayList<String>> anagrams(String[] arr) {
	        ArrayList<ArrayList<String>> res = new ArrayList<>();
	        Map<String, Integer> mp = new HashMap<>();
	        
	        for (int i = 0; i < arr.length; i++) {
	            String key = getHash(arr[i]);
	            
	            // If key is not present in the hash map, add
	            // an empty group (List) in the result and
	            // store the index of the group in hash map
	            if (!mp.containsKey(key)) {
	                mp.put(key, res.size());
	                res.add(new ArrayList<>());
	            }

	            // Insert the string in its correct group
	            res.get(mp.get(key)).add(arr[i]);
	        }

	        return res;
	    }

	    public static void main(String[] args) {
	        String[] arr = {"act", "god", "Aat","tAa", "dog", "tac"};
	        
	        ArrayList<ArrayList<String>> res = anagrams(arr);
	        
	        for (List<String> group : res) {
	            for (String word : group) {
	                System.out.print(word + " ");
	            }
	            System.out.println();
	        }
	    }
	}