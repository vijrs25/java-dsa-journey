package leetcode;

public class MaxDistance {

	public static void main(String[] args) {

		int[] nums = { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
		System.out.println(maxDistToClosest(nums));
	}

	public static int maxDistToClosest(int[] seats) {
		int maxcount = 0;
		int prev = -1;

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				if (prev == -1) {
					 // Leading zeros
					maxcount = i;
					System.out.println("maxcount " + maxcount + " i " + i);
				} else {
					 // Middle gap
					maxcount = Math.max(maxcount, (i - prev) / 2);
					System.out.println("maxcount " + maxcount + " i " + i + " prev " + prev);
				}
				prev = i;
			}
		}
		// Trailing zeros
		maxcount = Math.max(maxcount, seats.length - 1 - prev);
		return maxcount;

	}
}
