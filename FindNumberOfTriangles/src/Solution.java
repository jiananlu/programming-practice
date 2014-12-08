import java.util.*;

class Node {
	int node;
	Node(int node) {
		this.node = node;
	}
	public int hashCode() {
		return node;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Node)) return false;
		Node other = (Node) o;
		return this.node == other.node;
	}
}

class Edge {
	Node n1;
	Node n2;
	Edge(Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	public int hashCode() {
		return n1.hashCode() * 31 + n2.hashCode();
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Edge)) return false;
		Edge other = (Edge) o;
		return this.n1.equals(other.n1) && this.n2.equals(other.n2);
	}
}


public class Solution {
	public int numOfTriangles(Edge[] originalEdges) {
		Map<Node, List<Edge>> level1 = new HashMap<Node, List<Edge>>();
		Map<Edge, Integer> level2 = new HashMap<Edge, Integer>();
		int count = 0;
		for (Edge edge: originalEdges) {
			if (level2.containsKey(edge)) {
				count += level2.get(edge);
				continue;
			}
			if (level1.containsKey(edge.n1) || level1.containsKey(edge.n2)) {
				
			} else {
				putOrInsert(level1, edge.n1, edge);
				putOrInsert(level1, edge.n2, edge);
			}
		}
		return count;
	}
	
	void putOrInsert(Map<Node, List<Edge>> map, Node n, Edge e) {
		if (map.containsKey(n)) {
			map.get(n).add(e);
		} else {
			List<Edge> list = new ArrayList<Edge>();
			list.add(e);
			map.put(n, list);
		}
	}
	
	void putOrIncrement(Map<Node, Integer> map, Node key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key)+1);
		} else {
			map.put(key, 1);
		}
	}
}
