package problems;

import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:*/
public class Combinations {
public List<List<Integer>> combine(int n, int k) {
 	List<List<Integer>> sums = new ArrayList<List<Integer>>();
	List<Integer> result = null ;
		for(int i = 1;i<=(n-k+1);i++)
		{
			result.add(i);
			sums.add(result);
		}
        return sums;
    }
public static void main(String[] args) {
	System.out.println(new Combinations().combine(4, 2));
}
}
