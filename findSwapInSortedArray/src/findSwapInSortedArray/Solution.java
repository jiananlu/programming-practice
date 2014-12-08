package findSwapInSortedArray;

public class Solution {
	// 1 *6 3 4 5 *2 7 8, swap 6 and 2 to get the array sorted again
	// make the change in place. return the input array for easy printing
	public int[] findSwapInSortedArray(int[] arr) {
		int g = -1, l = -1;
		for (int i = 0; i < arr.length-1;i++) {
			if (arr[i] > arr[i+1]){
				g = i;
				break;
			}
		}
		for (int i = arr.length-1; i >0; i--) {
			if (arr[i] < arr[i-1]) {
				l = i;
				break;
			}
		}
		if (g==-1 || l==-2) return arr; // invalid input. not found anything to swap
		int t = arr[g];
		arr[g] =arr[l];
		arr[l] = t;
		return arr;
	}
	public static void main(String[]a) {
		Solution sol = new Solution();
		printArray(sol.findSwapInSortedArray(new int[] {1,6,3,4,5,2,7,8})); // normal swap
		printArray(sol.findSwapInSortedArray(new int[] {1,3,2,4})); // adjacent swap
		printArray(sol.findSwapInSortedArray(new int[] {1,4,3,2,5,6,7,8})); // one element in between
		printArray(sol.findSwapInSortedArray(new int[] {7,2,3,4,5,6,1,8})); // left edge
		printArray(sol.findSwapInSortedArray(new int[] {1,2,3,4,8,6,7,5})); // right edge
		printArray(sol.findSwapInSortedArray(new int[] {8,2,3,4,5,6,7,1})); // both edge
		printArray(sol.findSwapInSortedArray(new int[] {2,1,3,4,5,6,7,8})); // left edge and adjacent
		printArray(sol.findSwapInSortedArray(new int[] {1,2,3,4,5,6,8,7})); // right edge and adjacent
		printArray(sol.findSwapInSortedArray(new int[] {1,0})); // only two
	}
	public static void printArray(int[]arr) {
		for (int i: arr) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
}
