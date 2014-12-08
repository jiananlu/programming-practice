import java.util.*;


public class Solution {
	public List<List<Integer>> getAllProducts(int n) {
		List<List<Integer>> res = helper(n, n);
		if (res.size() > 0) {
			res.get(0).add(1);
		}
		return res;
	}
	
	private List<List<Integer>> helper(int n, int start) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 2) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(n);
			res.add(tmp);
			return res;
		}
		
		if (n <= start) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(n);
			res.add(tmp);
		}
		
		for(int i = Math.min(n, start)-1; i > 1; i--) {
			if (n%i != 0) continue;
			for (List<Integer> l: helper(n/i, i)) {
				l.add(0, i);
				res.add(l);
			}
		}
		
		return res;
	}
}
