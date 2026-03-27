package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*Input: intervals[][] = [[1, 3], [4, 5], [6, 7], [8, 10]], newInterval[] = [5, 6] 
Output: [[1, 3], [4, 7], [8, 10]]
Explanation: The intervals [4, 5] and [6, 7] are overlapping with [5, 6]. So, they are merged into one interval [4, 7]. 

Input: intervals[][] = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval[]  = [4, 9]
Output: [[1, 2], [3, 10], [12, 16]]
Explanation: The intervals [ [3, 5], [6, 7], [8, 10] ] are overlapping with [4, 9]. So, they are merged into one interval [3, 10].
*/
public class MatrixInsertandMergeInterval {
error
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 4, 5 }, { 6, 7 }, { 8, 10 } };
		int[] newInterval = { 5, 6 };

		ArrayList<int[]> res = insertInterval(intervals, newInterval);
		ArrayList<int[]> res1 = insertIntervalfast(intervals, newInterval);
		for (int[] interval : res1) {
			System.out.println(interval[0] + " " + interval[1]);
		}
	}

	private static ArrayList<int[]> insertIntervalfast(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> res = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] < newInterval[0]) {
				res.add(intervals[i]);
			}
		}

		for (int i = res.size(); i < intervals.length; i++) {
			System.out.println(i);
			if (intervals[i][0] <= newInterval[1]) {

				newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
				newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
				res.add(newInterval);
			}
		}
		
		for (int i = res.size(); i < intervals.length; i++) {
				res.add(intervals[i]);
		}

		return res;
	}

	private static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> liofArrays = new ArrayList<>(Arrays.asList(intervals));
		liofArrays.add(newInterval);

		return insertInterval(liofArrays.toArray(new int[0][]));

	}

	private static ArrayList<int[]> insertInterval(int[][] arrayOfarrays) {

		Arrays.sort(arrayOfarrays, (a, b) -> Integer.compare(a[0], b[0]));
		ArrayList<int[]> res = new ArrayList<>();
		res.add(arrayOfarrays[0]);

		for (int i = 1; i < arrayOfarrays.length; i++) {
			int last[] = res.get(res.size() - 1);
			int curr[] = arrayOfarrays[i];

			if (curr[0] <= last[1]) {
				last[1] = Math.max(curr[1], last[1]);
			} else
				res.add(curr);
		}
		return res;
	}

}
