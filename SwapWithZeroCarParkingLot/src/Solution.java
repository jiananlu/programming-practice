import java.util.*;


public class Solution {
	public void solve(int[] cars, int[] expectedCars) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i < cars.length; i++) {
			map.put(cars[i], i);
		}
		
		while (map.size() > 1) {
			int zeroPos = map.get(0);
			int expectedCar = expectedCars[zeroPos];
			if (expectedCar == 0) {
				int nextToMove = (Integer)map.keySet().toArray()[0];
				int nextPos = map.get(nextToMove);
				System.out.printf("move car %d from %d to %d\n", nextToMove, nextPos, zeroPos);
				map.put(0, nextPos);
				map.put(nextToMove, zeroPos);
			} else {
				int expectedCarCurrPos = map.get(expectedCar);
				System.out.printf("move car %d from %d to %d\n", expectedCar, expectedCarCurrPos, zeroPos);
				map.put(0, expectedCarCurrPos);
				map.remove(expectedCar);
			}
		}
	}
}
