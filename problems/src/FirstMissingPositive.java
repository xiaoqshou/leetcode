package problems;

import java.util.Arrays;

/*Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.*/
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int k = 0, i = 0;
		if (A.length != 0) {
			Arrays.sort(A);
			for (; (i < A.length) && A[i] < 0; i++)				;
			for (; (i < A.length) && ((A[i] - k) <= 1); i++) {
				k = A[i];
			}
		}
		return k + 1;
	}
	public static void main(String[] args) {
		int[] t = new int[]{3,4,-1,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(t));
	}
}
