import java.util.*;



public class DequeSol implements Solution {
	@Override
	public int[] localMin(int[] input, int k) {
		if (input.length - k+1 <= 0) return null;
		
		int[] mins = new int[input.length - k +1];
		
		Deque<Pair> q = new ArrayDeque<Pair>();
		
		for (int i = 0; i < k; i++) {
			appendUntilLess(q, new Pair(input[i], i));
		}
		
		mins[0] = q.getFirst().key;
		
		for (int i = 1; i < input.length - k+1; i++) {
			appendUntilLess(q, new Pair(input[i+k-1], i+k-1));
			while (q.getFirst().index < i) {
				q.removeFirst();
			}
			mins[i] = q.getFirst().key;
		}
		
		return mins;
	}
	
	void appendUntilLess(Deque<Pair>q, Pair p) {
		while (!q.isEmpty() && q.getLast().key >= p.key) {
			q.removeLast();
		}
		q.addLast(p);
		
	}

}
