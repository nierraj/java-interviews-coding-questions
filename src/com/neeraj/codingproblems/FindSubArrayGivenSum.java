package com.neeraj.codingproblems;

import java.util.HashMap;


/**
 * Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with the sum as the given number, print any of them.
 *  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Output: Sum found between indexes 2 and 4
	Explantion: Sum of elements between indices
	2 and 4 is 20 + 3 + 10 = 33
	
	Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
	Output: Sum found between indexes 0 to 3
	Explantion: Sum of elements between indices
	0 and 3 is 10 + 2 - 2 - 20 = -10
	
	Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
	Output: No subarray with given sum exists
	Explantion: There is no subarray with the given sum
 * 
 *
 */

/* Solution: https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 * 1. create a Hashmap (hm) to store key value pair, i.e, key = prefix sum and value = its index and a variable to store the current sum (sum = 0) and the sum of subarray as s
   2. Traverse through the array from start to end.
   3. For every element update the sum, i.e sum = sum + array[i]
   4. If sum is equal to s then print that the subarray with given sum is from 0 to i
   5. If there is any key in the HashMap which is equal to sum – s then print that the subarray with given sum is from hm[sum – s] to i
   6. Put the sum and index in the hashmap as key-value pair.
 * 
 */
public class FindSubArrayGivenSum {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -10;
		subArraySum(arr, n, sum);

	}

	public static void subArraySum(int[] arr, int n, int sum) {
		// cur_sum to keep track of cummulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
		}
	}
}
