import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return b-a;
        	}
        });
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return a-b;
        	}
        });

        for(int i: A) {
        	addToQ(maxQ, minQ, i);
        }
        for(int i: B) {
        	addToQ(maxQ, minQ, i);
        }
        
        if (maxQ.size() == 0 && minQ.size() == 0) return 0;
        if (maxQ.size() == minQ.size()) return ((double)maxQ.peek() + (double)minQ.peek())/2;
        else if (maxQ.size() > minQ.size()) return maxQ.peek();
        else return minQ.peek();
    }

    void addToQ(PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ, int i) {
    	
    	if (maxQ.isEmpty() || i <= maxQ.peek()) maxQ.add(i);
    	else minQ.add(i);

    	if (maxQ.size() - minQ.size() >= 2) {
    		minQ.add(maxQ.poll());
    	}
    	else if (minQ.size() - maxQ.size() >= 2) {
    		maxQ.add(minQ.poll());
    	}
    }
}