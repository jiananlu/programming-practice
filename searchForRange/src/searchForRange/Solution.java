package searchForRange;

//Given a sorted array of integers,
//find the starting and ending position of a given target value.

//Your algorithm's runtime complexity must be in the order of O(log n).

//If the target is not found in the array, return [-1, -1].

//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class Solution {
	public static void main(String[]a) {
		Solution s =new Solution();
		s.printHelper(new int[]{1,4}, 4);
	}
	public void printHelper(int[]A, int target) {
		for (int i: searchRange(A, target)) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
	public int[] searchRange(int[] A, int target) {
	    int[] res = new int[2];
	    res[0]=-1;
	    res[1]=-1;
	        
	    if (A.length == 0) return res;
	
	    int low = 0, high = A.length-1, t = -1;
	    while (low <= high) {
	        int middle = low+(high - low)/2;
	        int m = A[middle];
	        if (target >m) {
	            low = middle+1;
	            continue;
	        }
	        if (target <m) {
	            high = middle-1;
	            continue;
	        }
	        if (target == m) {
	            t = middle;
	            break;
	        }
	    }
	    if (t == -1) return res;
	
	    // find the begin
	    int ll = low, hh = t;
	    while (ll <= hh) {
	        int middle = ll+(hh-ll)/2;
	        int m =A[middle];
	        if (target >m) ll = middle+1;
	        if (target <=m) hh = middle-1;
	    }
	    res[0] = ll;
	
	    // find the end
	    ll = t;
	    hh = high;
	    while (ll <= hh) {
	        int middle = ll+(hh-ll)/2;
	        int m = A[middle];
	        if (target>=m) ll = middle+1;
	        if (target<m) hh = middle - 1;
	    }
	    res[1] = hh;
	    return res;
	}
}