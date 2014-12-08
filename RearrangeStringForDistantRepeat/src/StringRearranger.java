import java.util.*;

/*
 * (2)给一串无序char,再给个int m,重构这串char,使相同的char之间的距离至少是m。

example:

Input: caabacde, 2

Output:acbacdae

Input: aaaccc, 2

Output: 无解

扫一遍,用hashmap记录每个char出现次数。次数多的急于被安置的priority越高。然后开始一个一个的码这些

char,同一个char在m内别重复,一但超过m以后要优先考虑码放所剩次数最多的char。一开始用brute force,

后来提示下用java里的priority queue (min heap)。个人觉得这题相当hardcore。

 */


class StringRearrangerBuilder {
	class Pair {
		char c;
		int count;
		Pair(char c, int count) {
			this.c = c;
			this.count = count;
		}
		void incrementCount() {
			count++;
		}
		void decrementCount() {
			count--;
		}
	}
	
	int limit; // the space between two repeated chars
	int totalChars = 0;
	Map<Character, Pair> map;
	PriorityQueue<Pair> pq;
	Queue<Pair> q;
	
	StringRearrangerBuilder(int limit) {
		this.limit = limit;
		map = new HashMap<Character, Pair>();
	}
	
	void preprocess(char c) {
		if (map.containsKey(c)) {
			map.get(c).incrementCount();
		} else {
			map.put(c, new Pair(c, 1));
		}
		totalChars++;
	}
	
	void done() {
		pq = new PriorityQueue<Pair>(map.size(), new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p2.count - p1.count;
			}
		});
		for (Map.Entry<Character, Pair> e: map.entrySet()) pq.add(e.getValue());
		q = new LinkedList<Pair>();
	}
	
	void reset() {
		map.clear();
		totalChars = 0;
	}
	
	// done with preprocess and build the priority queue
	String build() {
		done();
		
		StringBuilder sb = new StringBuilder();
		while (hasNext()) {
			sb.append(next());
			if (sb.length() == totalChars) return sb.toString();
		}
		return null;
	}
	
	boolean hasNext() {
		return !pq.isEmpty();
	}
	
	char next() {
		if (pq.isEmpty()) throw new NoSuchElementException();
		Pair p = pq.remove();
		char res = p.c;
		p.decrementCount();
		q.add(p);
		if (q.size() > limit) {
			p = q.remove();
			if (p.count > 0) pq.add(p);
		}
		return res;
	}
}

public class StringRearranger {
	String rearrange(String s, int m) {
		StringRearrangerBuilder builder = new StringRearrangerBuilder(m);
		for (char c: s.toCharArray()) {
			builder.preprocess(c);
		}
		return builder.build();
	}
}

