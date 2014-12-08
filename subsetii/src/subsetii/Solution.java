package subsetii;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> prev = new ArrayList<List<Integer>>(), next = new ArrayList<List<Integer>>();
        prev.add(new ArrayList<Integer>());
        if (num.length==0) return prev;
        
        Arrays.sort(num);
        
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(num[0]);
        next.add(tmp);
        
        for (int i = 1; i < num.length; i++) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (List<Integer> list: prev) {
            	res.add(new ArrayList<Integer>(list));
            }
            
            for (List<Integer> list: next) {
            	res.add(new ArrayList<Integer>(list));
                list.add(num[i]);
            }
            
            if (num[i]!=num[i-1]) {
                for(List<Integer> list: prev) {
                    list.add(num[i]);
                    next.add(list);
                }
            }
            
            prev = res;
        }
        prev.addAll(next);
        return prev;
    }
}