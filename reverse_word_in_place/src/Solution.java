
public class Solution {
	String solve(String str) {
		char[] arr = str.toCharArray();
		int start=0, end=0;
		while(start<arr.length) {
			if(arr[start]==' ') start++;
			else {
				end=start+1;
				while(end<arr.length && arr[end]!=' ') end++;
				rev(arr, start, end-1);
				start=end+1;
			}
		}
		return new String(arr);
		
	}
	
	void rev(char[] arr, int start, int end) {
		while(start < end) {
			char t = arr[start];
			arr[start]  =arr[end];
			arr[end]=t;
			start++;
			end--;
		}
	}
}
