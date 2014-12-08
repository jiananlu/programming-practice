import java.util.Map;
import java.util.TreeMap;


public class SubOpt implements Solution {
	public int[] localMin(int[] input, int k) {
		if (input.length - k + 1 <= 0) return null;
		int[] mins = new int[input.length - k + 1];
		
		TreeMap<Integer, Integer>map = new TreeMap<Integer, Integer>();
		
		for (int i =0; i< k; i++) {
			addOrInc(map, input[i]);
		}
		
		
		mins[0] = map.firstKey();
				
		for (int i = 1; i < input.length - k+1; i++) {
			decOrRemove(map, input[i-1]);
			addOrInc(map, input[i+k-1]);
			mins[i] = map.firstKey();
		}
		
		return mins;
	}
	
	 void addOrInc(Map<Integer, Integer> map, int k) {
		if (map.containsKey(k)) {
			map.put(k, map.get(k)+1);
		} else {
			map.put(k, 1);
		}
	}
	
	void decOrRemove(Map<Integer, Integer>map, int k) {
		if (map.get(k) <= 1) {
			map.remove(k);
		} else {
			map.put(k, map.get(k)-1);
		}
	}
}
