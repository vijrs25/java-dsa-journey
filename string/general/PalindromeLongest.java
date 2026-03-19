package string.general;

public class PalindromeLongest {
//Input: nums = [1,2,5,9], threshold = 6
//	Output: 5

// ceil nums = [1, 2, 5, 9] and threshold = 6
//o/p: 5 	
	public static void main(String[] args) {
		double arr[] = { 44,22,33,11,1 };
		int threshold = 5;
		int currSum = 0;
		int count = 1;
		boolean flag = true;
		while (flag) {
			currSum = 0;

			for (int i = 0; i < arr.length; i++) {
				currSum += Math.ceil(arr[i]/count);
				System.out.println("current Sum ="+currSum+" arr[i] ="+arr[i]+ " count "+ count);
			}
			if (currSum <= threshold) {
				flag = false;
				System.out.println(count);
				
			}
			count++;
		}

	}

}
