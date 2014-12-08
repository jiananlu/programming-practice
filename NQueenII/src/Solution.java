public class Solution {
    public int totalNQueens(int n) {
        return helper(new int[n], 0);
    }
    
    int helper(int[]A, int col) {
        if (col >= A.length) return 1;
        
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) { // i is the row number
        	A[col] = i;
            if (!isValid(A, col, i)) continue;
            sum += helper(A, col+1);
        }
        
        return sum;
    }
    
    private boolean isValid(int[]A, int col, int row) {
        for (int c = 0; c < col; c++) {
            // first check all cols before this col
            if (A[c] == row) return false;
            // then check diagnoe
            if (Math.abs(A[c] - A[col]) == Math.abs(c-col)) return false;
        }
        return true;        
    }
}