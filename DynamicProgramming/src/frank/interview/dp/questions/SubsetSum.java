package frank.interview.dp.questions;

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

}
