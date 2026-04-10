package string;

public class MaxConsecutiveChar {

	public static void main(String[] args) {
		
		String a = "aaabbbaaeeeeeeeaazzzzbb";
		
		int cnt = 0;
		int max = 0;
		char res =  '1';
		for(int i = 1; i<a.length();i++) {
			
			if(a.charAt(i)==a.charAt(i-1)) {
				cnt++;
			}
			else {
				cnt = 0;
			}
			if(cnt>max) {
				max= cnt;
				res= a.charAt(i-1);
			}
		}
		System.out.println(res+" "+max);
	}

}
