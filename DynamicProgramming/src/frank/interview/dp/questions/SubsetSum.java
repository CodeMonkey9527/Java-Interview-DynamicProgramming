package frank.interview.dp.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive integers, find a subset of the array which sums up to another number
 * Example: 
 * {1, 3, 5, 7} and number 10, then {3, 7} sums to 10
 * Algorithm: 
 * Denote the array as {a1, a2, ... , an} 
 * Let S[i][s] = true  if there is a subset of {a1, a2, ... , ai}, which sums to number s 
 *     S[i][s] = false if there is no such subset
 * Then S[i][s] = S[i-1][s] || (ai == s) || S[i-1][s-ai]
 *  let A = a1 + a2 + ... + an
 *  then S[i][s] = false if s < 0 or s > A 
 * Complexity of the algorithm is O(n*A), and it is pseudo polynomial
 * @author shenshi
 *
 */
public class SubsetSum {

	private static int total(int [] array) {
		int total = 0;
		for (int n : array) {
			total += n;
		}
		return total;
	}
	
	public static List<Integer> find(int [] array, int num) {
		if (array == null || array.length == 0) {
			return null;
		}
		if (num == 0) {
			// return empty set if target is 0
			return new ArrayList<Integer>();
		}
		String failureOutput = String.format("Can't find subset for %d", num);
		if (num < array[0]) {
			System.out.println(failureOutput);
			return null;
		}
		int maxSum = total(array);
		if (num > maxSum) {
			System.out.println(failureOutput);
			return null;
		}
		int length = array.length;
		boolean [][] result = new boolean[length][num + 1];
		int [][] back = new int [length][num + 1];
		// initial cases
		for (int i = 0; i <= num; i++) {
			result[0][i] = false;
			back[0][i] = 0;
		}
		for (int i = 0; i < length; i++) {
			result[i][0] = true;
			back[i][0] = 1;
		}
		result[0][array[0]]  = true;
		back[0][array[0]] = 2;
		
		// going forward
		for (int i = 1; i < length; i++) {
			for (int s = 0; s <= num; s++) {
				if (result[i-1][s]) {
					// if s can be sum'ed to by a1, a2, ... , ai-1
					result[i][s] = true;
					back[i][s] = 1;
				} else if (s >= array[i] && result[i-1][s-array[i]]) {
					// if s-ai can be sum'ed to by a1, a2, ... , ai-1
					result[i][s] = true;
					back[i][s] = 2;
				} else {
					result[i][s] = false;
					back[i][s] = 0;
				}
			}
		}
		
		// going backward
		if (result[length - 1][num] == false) {
			System.out.println(failureOutput);
			return null;
		}
		List<Integer> subset = new ArrayList<Integer>();
		int n = length - 1;
		int s = num;
		while(n >= 0) {
			if (back[n][s] == 1) {
				n--;
			} else if (back[n][s] == 2) {
				subset.add(array[n]);
				s -= array[n];
				n--;
			} else {
				throw new IllegalStateException("Impossible!");
			}
		}
		
		StringBuffer output = new StringBuffer();
		output.append(num);
		output.append("=");
		if (subset.size() > 0) {
			output.append(subset.get(0));
		}
		for (int i = 1; i < subset.size(); i++) {
			output.append("+");
			output.append(subset.get(i));
		}
		System.out.println(output);
		
		return subset;
	}
	
}