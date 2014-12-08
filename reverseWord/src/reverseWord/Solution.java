package reverseWord;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */
import java.util.ArrayList;
import java.util.List;

class Pair {
    int start;
    int end;
}

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        boolean started = false;
        List<Pair> pairs = new ArrayList<Pair>();
        Pair pair = null;
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            if (started) {
                if (c == ' ') {
                    pair.end = i;
                    started = false;
                    pairs.add(pair);
                }
            } else {
                if (c != ' ') {
                	pair = new Pair();
                    pair.start = i;
                    started = true;
                }
            }
        }
        if (started) {
            pair.end = s.length();
            pairs.add(pair);
        }

        StringBuilder b = new StringBuilder();
        for (int i = pairs.size()-1; i >= 0; i--) {
        	Pair p = pairs.get(i);
            b.append(s.substring(p.start, p.end));
            b.append(" ");
        }
        return b.toString();
    }
    
}