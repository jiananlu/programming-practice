
public class Solution {
	public boolean match(String pattern, String s) {
	    int i = 0, j = 0;
	    while(i < pattern.length()) {
	        if (pattern.charAt(i) == '*') break;
	        if (i >= s.length())
	            if (i < pattern.length()) return false;
	            else return true;
	        if (pattern.charAt(i) != s.charAt(i)) return false;
	        i++;
	    }
	    while(j < pattern.length()) {
	        if (pattern.charAt(pattern.length()-1-j) == '*') break;
	        if (s.length()-1-j < i)
	            if (pattern.length()-1-j > i) return false;
	            else return true;
	        if (pattern.charAt(pattern.length()-1-j) != s.charAt(s.length()-1-j)) return false;
	        j++;
	    }
	    return true;
	}

}
