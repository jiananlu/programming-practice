public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int l = A.length+B.length;
        if((l&1)==0) {
            double t = (double)findk(A,0,A.length,B,0,B.length,l/2+1);
            double p = (double)findk(A,0,A.length,B,0,B.length,l/2);
            return (t+p)/2;
            
        } else {
            return findk(A,0,A.length,B,0,B.length,l/2+1);
        }
    }
    
    private void printArr(String name, int[]A, int sa, int la) {
    	System.out.print(name+": [");
    	for (int i=0; i<la; i++) {
    		System.out.print(A[sa+i]+", ");
    	}
    	System.out.println("]");
    }
    
    private int findk(int[]A, int sa, int la, int[]B, int sb, int lb, int k) {
    	printArr("A", A, sa, la);
    	printArr("B", B, sb, lb);
    	
        if (la>lb) return findk(B,sb,lb, A,sa,la, k);
        if (la == 0) return B[sb+k-1];
        if (k==1) return Math.min(A[sa], B[sb]);
        int ka = Math.min(la, k/2), kb=k-ka;
        int pa = sa+ka, pb=sb+kb;
        if (A[pa-1] < B[pb-1]) {
        	System.out.printf("A[%d]=%d < B[%d]=%d\n", pa-1, A[pa-1], pb-1, B[pb-1]);
            return findk(A, pa, la-ka, B, sb, lb-kb+1, k-ka);
        } 
        else if (A[pa-1] > B[pb-1]) {
        	System.out.printf("A[%d]=%d > B[%d]=%d\n", pa-1, A[pa-1], pb-1, B[pb-1]);
            return findk(A, sa, la-ka+1, B, pb, lb-kb, k-kb);
        } else {
        	System.out.printf("A[%d]=%d == B[%d]=%d\n", pa-1, A[pa-1], pb-1, B[pb-1]);
        	return A[pa-1];
        }
    }
}