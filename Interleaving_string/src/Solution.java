public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1+len2!=s3.length()) return false;
        if (len1==0) return s2.equals(s3);
        if (len2==0) return s1.equals(s3);
        boolean[][] D = new boolean[len1][len2];
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                boolean f1 = i==0? true : D[i-1][j];
                boolean f2 = j==0? true : D[i][j-1];
                int k = i+j+1;
                D[i][j] = (f1&&(s1.charAt(i)==s3.charAt(k))) || (f2&&(s2.charAt(j)==s3.charAt(k)));
            }
        }
        
        return D[len1-1][len2-1];
    }
}