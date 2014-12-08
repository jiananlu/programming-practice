package word_ladder;

import java.util.*;

public class Solution {
    Map<String, List<String>> cache = new HashMap<String, List<String>>();
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<String> frontier = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        frontier.add(start);
        visited.add(start);
        
        Map<String, Set<String>> parents = new HashMap<String, Set<String>>();
        
        while(!frontier.isEmpty()) {
            List<String> next = new LinkedList<String>();
            Set<String> toVisit = new HashSet<String>();
            
            for (String f: frontier) {
                if (f.equals(end)) { // found the word, get the paths
                	return getPaths(f, parents);
                }
                for (String w: getWords(f, dict)) {
                    if (visited.contains(w)) continue;
                    next.add(w);
                    toVisit.add(w);
                    
                    if (!parents.containsKey(w)) {
                        parents.put(w, new HashSet<String>());
                    }
                    parents.get(w).add(f);
                }
            }
            
            frontier = next;
            visited.addAll(toVisit);
        }
        
        return new ArrayList<List<String>>(); // not found
    }
    
    List<String> getWords(String s, Set<String> dict) {
        if (cache.containsKey(s)) return cache.get(s);
        
        List<String> res = new ArrayList<String>(25 * s.length());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char orig = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == orig) continue;
                chars[i] = c;
                String ss = new String(chars);
                if (dict.contains(ss)) res.add(ss);
            }
            chars[i] = orig;
        }
        
        cache.put(s, res);
        return res;
    }
    
    List<List<String>> getPaths(String root, Map<String, Set<String>> parents) {
        List<List<String>> res = new ArrayList<List<String>>();
        DFS(root, parents, new ArrayList<String>(), res);
        return res;
    }
    
    void DFS(String root, Map<String, Set<String>> parents, List<String> curr, List<List<String>> res) {
        curr.add(0, root);
        
        if (parents.containsKey(root)) {
            for (String p: parents.get(root)) {
                DFS(p, parents, curr, res);
            }
        } else res.add(new ArrayList<String>(curr));
        
        curr.remove(0);
    }
}