
public class Solution {
    void reverseInPlace(char[] chars, int start, int end) {
        if (chars == null || chars.length <= 1) return;
        int i = start, j = end;
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
    
    String reverse(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int i = 0, j = 0, len = chars.length;        
        while (j < len) {
            if (chars[j] != ' ') {
                j++;
                continue;
            }
            reverseInPlace(chars, i, j - 1);
            
            while (j < len && chars[j] == ' ') j++;
            i = j;
        }
        if (j == len && chars[j - 1] != ' ') {
            reverseInPlace(chars, i, j - 1);
        }
        return new String(chars);
    }

    
}
