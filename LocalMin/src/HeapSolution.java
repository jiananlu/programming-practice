import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int key;
	int index;
	Pair(int key, int index) {
		this.key = key;
		this.index = index;
	}
	@Override
	public int compareTo(Pair o) {
		
		return this.key - o.key;
	}
}

public class HeapSolution implements Solution {
	public int[] localMin(int[] input, int k) {
		if (input.length - k+1 <= 0) return null;
		
		int[] mins = new int[input.length - k +1];
		
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		for (int i = 0; i < k; i++) {
			q.offer(new Pair(input[i], i));
		}
		
		mins[0] = q.peek().key;
		
		for (int i = 1; i < input.length - k +1; i++) {
			q.offer(new Pair(input[i+k-1], i+k-1));
			while (q.peek().index < i) {
				q.poll();
			}
			mins[i] = q.peek().key;
		}
		
		return mins;
	}
}
