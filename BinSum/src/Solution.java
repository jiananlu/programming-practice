public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        int carry = 0;
        StringBuilder builder = new StringBuilder();

        int lenA = a.length(), lenB = b.length();
        int longerLen = lenA > lenB ? lenA : lenB;

        for (int i = 1; i <= longerLen; i++) {
            int iA = 0, iB = 0;
            char cA = '0', cB = '0';
            if (i <= lenA) {
                cA = a.charAt(lenA - i);
            }
            if (i <= lenB) {
                cB = b.charAt(lenB - i);
            }
            if (cA == '1') iA = 1;
            if (cB == '1') iB = 1;
            int s = iA + iB + carry;
            char d = '0';
            if (s % 2 == 1) d = '1';
            builder.insert(0, d);
            carry = s / 2;
        }

        if (carry == 1) builder.insert(0, '1');
        return b.toString();
    }
    
    public static void main(String[]a) {
    	Solution s = new Solution();
    	String res = s.addBinary("1", "0");
    	System.out.println(res);
    }
}