/*Given an array A[1, 2, . . . , n] of distinct elements, an inversion is a pair (i, j) of indices
such that i < j and A[i] > A[j]. Eg: The sequence 3,8,0,-4,1 has 7 inversions, namely
the pairs (1,3), (1,4), (1,5), (2,3), (2,4), (2,5), (3,4).
Write a program to count the number of inversions of a given array. The algorithm behind
your input should run in O(n log n) time.
Input format: The first line of the input consists of a single integer: n, the number of
elements in the array. The second line of the input consists of the elements of the array,
separated by a space.
Sample Input:
5
3 8 0 -4 -1
Sample Output:
7
Constraints: n ≤ 105
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionPair {

		//Implementing modified merge sort to count inversions
	    private static int mergeCountInversion(int[] nums, int l, int r) {
	        if (l >= r) return 0;
	        int count = 0;
	        int mid = l + (r - l) / 2;//using divide and conquer finding mid
	        count += mergeCountInversion(nums, l, mid);//1st subarray
	        count += mergeCountInversion(nums, mid + 1, r);//2nd subarray
	        count += merge(nums, l, mid, r);//For merging 2 sub arrays
	        return count;
	    }
	    private static int merge(int[] nums, int l, int mid, int r) {
	        int count_inv = 0, l1 = l, l2 = mid + 1, index = 0;
	        while (l1 <= mid && l2 <= r) {
	            if ((l1<l2) &&(long) nums[l1] > (long)nums[l2]) {//Inversion logic if i<j and A[i]>A[j] than it's inversion
	                count_inv += mid - l1 + 1;
	                l2++;
	            } else l1++;
	        }
	        l1 = l;
	        l2 = mid + 1;
	        int[] copy = new int[r - l + 1];
	        while (l1 <= mid && l2 <= r) {
	            if (nums[l1] > nums[l2]) copy[index++] = nums[l2++];//copying elements
	            else copy[index++] = nums[l1++];
	        }
	        while (l1 <= mid) copy[index++] = nums[l1++];
	        while (l2 <= r) copy[index++] = nums[l2++];
	        System.arraycopy(copy, 0, nums, l, r - l + 1);
	        return count_inv;//returns number of inversions
	    }
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		// int[] arr = { 1, 20, 6, 4, 5 };
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		int noOfInputs = Integer.parseInt(reader.readLine());
		System.out.println("No of inputs" + noOfInputs);
		if(noOfInputs<=Math.pow(10, 5)) {//check valid input
		int[] nums = new int[noOfInputs];
		String str = reader.readLine();
		String[] s1 = str.split(" ");
		for (int i = 0; i < noOfInputs; i++) {
			nums[i] = Integer.parseInt(s1[i]);
		}
		System.out.println("Inversion count is::" + mergeCountInversion(nums, 0, nums.length - 1));

	}
		else {
			System.out.println(" Invalid No of inputs");//Invalid Input
		}

}}
