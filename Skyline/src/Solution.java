import java.util.*;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}
}

class Edge {
	boolean isUp = false;
	int x;
	Block block;
	Edge(int x, boolean isUp, Block block) {
		this.x = x;
		this.isUp = isUp;
		this.block = block;
	}
	public String toString() {
		if (isUp)
			return String.format("%d.up", x);
		else
			return String.format("%d.dn", x);
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Edge)) return false;
		Edge other = (Edge) o;
		return isUp == other.isUp && x == other.x;
	}
	
	public int hashCode() {
		return x * 31 + (isUp ? 1 : 0);
	}
}

class Block implements Comparable<Block> {
	int y;
	Edge upEdge, downEdge;
	
	Block(int x1, int x2, int y) {
		this.upEdge = new Edge(x1, true, this);
		this.downEdge = new Edge(x2, false, this);
		this.y = y;
	}
	
	@Override
	public int compareTo(Block arg0) {
		return this.y - arg0.y;
	}
	
	public String toString() {
		return String.format("(%d,%d)=%d", upEdge.x, downEdge.x, y);
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Block)) return false;
		Block other = (Block) o;
		return upEdge.equals(other.upEdge) && downEdge.equals(other.downEdge) && y == other.y;
	}
	
	public int hashCode() {
		int hash = y * 31;
		hash += upEdge.hashCode();
		hash *= 31;
		hash += downEdge.hashCode();
		hash *= 31;
		return hash;
	}
}

public class Solution {
	List<Edge> mergeSortBlocksEdges(List<Block> blocks) {
		List<Block> another = new ArrayList<Block>();
		for (Block b: blocks) {
			another.add(new Block(b.upEdge.x, b.downEdge.x, b.y));
		}
		Collections.sort(blocks, new Comparator<Block>(){
			@Override
			public int compare(Block o1, Block o2) {
				return o1.upEdge.x - o2.upEdge.x;
			}
		});
		Collections.sort(another, new Comparator<Block>(){
			@Override
			public int compare(Block o1, Block o2) {
				return o1.downEdge.x - o2.downEdge.x;
			}
		});
		List<Edge> res = new ArrayList<Edge>();
		int i = 0, j = 0;
		while (i < blocks.size() && j < another.size()) {
			if (blocks.get(i).upEdge.x < another.get(j).downEdge.x) {
				res.add(blocks.get(i).upEdge);
				i++;
			} else {
				res.add(another.get(j).downEdge);
				j++;
			}
		}
		while (i < blocks.size()) {
			res.add(blocks.get(i).upEdge);
			i++;
		}
		while (j < another.size()) {
			res.add(another.get(j).downEdge);
			j++;
		}
		return res;
	}
	
	List<Edge> sortBlocksEdges(List<Block> blocks) {
		List<Edge> res = new ArrayList<Edge>();
		for (Block b: blocks) {
			res.add(b.upEdge);
			res.add(b.downEdge);
		}
		Collections.sort(res, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.x - o2.x;
			}
		});
		return res;
	}
	
	public List<Point> skyliner(List<Block> blocks) {
		List<Point> points = new ArrayList<Point>();
		PriorityQueue<Block> q = new PriorityQueue<Block>(blocks.size(), new Comparator<Block>(){
			@Override
			public int compare(Block arg0, Block arg1) {
				return arg1.y - arg0.y;
			}
		});
		q.add(new Block(0, Integer.MAX_VALUE, 0));
		int curr = 0;
		List<Edge> edges = mergeSortBlocksEdges(blocks);
		for (Edge e: edges) {
			if (e.isUp) {
				q.add(e.block);
				if (e.block.y > curr) {
					points.add(new Point(e.x, curr));
					points.add(new Point(e.x, e.block.y));
					curr = e.block.y;
				}
			} else {
				q.remove(e.block);
				if (q.peek().y < curr) {
					points.add(new Point(e.x, curr));
					points.add(new Point(e.x, q.peek().y));
					curr = q.peek().y;
				}
			}
		}
		return points;
	}
}
