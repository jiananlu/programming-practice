public class Solution {
	public int longestNonDecSeq(int [] arr) {
		if (arr.length == 0) return 0;
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] >= arr[j] && res[j] > max) max = res[j]; 
			}
			res[i] = max+1;
		}
		return res[arr.length-1];
	}
}
