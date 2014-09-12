package problems;

import java.util.Arrays;
import java.util.Vector;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		for(int i=1;i<num.length;i++)
		{
			num[i]=num[i]-target;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[]  num = new int[]{2,1,3,2,5};
		System.out.println(new ThreeSumClosest().threeSumClosest(num, 0));
	}
}


