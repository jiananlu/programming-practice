import java.util.*;


public class ReadersWriterLock {
	Thread writter = null;
	int writeCount = 0;
	int writeRequests = 0;
	Map<Thread, Integer> map = new HashMap<Thread, Integer>();

	public synchronized void lockRead() throws InterruptedException {
		while (!canRead()) {
			wait();
		}
		addToReadMap();
	}
	
	public synchronized void unlockRead() {
		Thread curr = Thread.currentThread();
		if (map.containsKey(curr)) {
			if (map.get(curr) == 1) map.remove(curr);
			else map.put(curr, map.get(curr)-1);
			notifyAll();
		}
	}
	
	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		while(!canWrite()) wait();
		writter = Thread.currentThread();
		writeRequests--; // request fulfilled
		writeCount++;
	}
	
	public synchronized void unlockWrite() {
		if (writter == Thread.currentThread() && --writeCount == 0) {
			writter = null;
			notifyAll();
		}
	}
	
	private synchronized boolean canRead() {
		if (writter != null) return false;
		if (map.containsKey(Thread.currentThread())) return true;
		if (writeRequests > 0) return false;
		return true;
	}
	
	private synchronized boolean canWrite() {
		if (map.size() > 0) return false;
		if (writter != null && writter != Thread.currentThread()) return false;
		return true;
	}
	
	private synchronized void addToReadMap() {
		Thread curr = Thread.currentThread();
		if (map.containsKey(curr)) map.put(curr, map.get(curr)+1);
		else map.put(curr, 1);
	}
}
