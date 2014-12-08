package miniWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String[]a) {
		Solution s = new Solution();
		s.printHelper("a", "aa");
		s.printHelper("a", "a");
		s.printHelper("ADOBECODEBANC", "ABC");
	}
	public void printHelper(String a, String b) {
		System.out.println("result="+minWindow(a, b));
	}
    public String minWindow(String S, String T) {
        if (T==null || T.isEmpty()) return null;
        if (S== null || S.isEmpty()) return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Set<Character> isFullSet = new HashSet<Character>();
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        
        for (char c: T.toCharArray()) {
            int v = 1;
            if (freq.containsKey(c)) v = freq.get(c)+1;
            freq.put(c, v);
        }
        
        int i = 0, j = 0;
        String min = S;
        boolean found = false;
        while(i < S.length() || j < S.length()) {
            boolean isfull = isFullSet.size() == freq.size();
            if (i>=S.length() && !isfull) break;
            if (isfull) {
                if (i-j <= min.length()) {
                	found = true;
                    min = S.substring(j, i);
                }
                tryToDecrement(map, freq, isFullSet, S.charAt(j));
                j++;
            } else {
                tryToIncrement(map, freq, isFullSet, S.charAt(i));
                i++;
            }
        }
        if (!found) return "";
        return min;
    }
    void tryToIncrement(Map<Character, Integer> map, Map<Character, Integer> freq, Set<Character> isFullSet, char c) {
        if (!freq.containsKey(c)) {
            return;
        }
        int v = 1;
        if (map.containsKey(c)) {
            v = map.get(c)+1;
        }
        map.put(c, v);
        if (v >= freq.get(c)) {
            isFullSet.add(c);
        }
    }
    void tryToDecrement(Map<Character, Integer>map, Map<Character, Integer> freq, Set<Character> isFullSet,  char c) {
        if (!freq.containsKey(c)||!map.containsKey(c)) return;
        int v = map.get(c);
        if (v <= 1) {
            map.remove(c);
        } else {
            map.put(c, v-1);
        }
        if (v-1 < freq.get(c)) {
            isFullSet.remove(c);
        }
    }
}