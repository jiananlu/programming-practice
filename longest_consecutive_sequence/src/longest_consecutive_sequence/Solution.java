package longest_consecutive_sequence;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] num) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: num) {
            if (map.containsKey(i)) continue;
            int left = i, right = i;
            if (map.containsKey(i-1)) left = map.get(i-1);
            if (map.containsKey(i+1)) right = map.get(i+1);
            map.put(left, right);
            map.put(right, left);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}