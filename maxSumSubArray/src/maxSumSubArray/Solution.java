package maxSumSubArray;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.helper(new int[]{1, 2, -1, -1, 1, 2});
		s.helper(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		s.helper(new int[]{-3, -4, -5});
		s.helper(new int[]{1,2,3,4});
		s.helper(new int[]{});
	}
	
	public void helper(int[]arr) {
		for (int i: maxSum(arr)) {
			System.out.print(i+", ");
			
		}
		System.out.println();
	}
	
	public int[] maxSum(int[] arr) {
		if (arr.length == 0) return new int[0];
		int begin = 0, tbegin = 0, end = 0, max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i< arr.length; i++) {
			if (sum < 0) {
				sum = 0;
				tbegin = i;
			}
			sum += arr[i];
			if (sum > max) {
				max = sum;
				begin = tbegin;
				end = i;
			}
		}
		int[] res = new int[end - begin + 1];
		for (int i = 0; i< res.length; i++) {
			res[i] = arr[begin+i];
		}
		return res;
	}


}
