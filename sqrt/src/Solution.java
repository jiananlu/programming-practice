public class Solution {
    public int sqrt(int x) {
        if(x<=0)return x;
        int l=1, r=x/2+1;
        while(l<=r){
            int m=l+(r-l)/2;
            long msq = (long)m*m, m1sq=(long)(m+1)*(m+1);
            if(x >= msq && x < m1sq) return m;
            else if (x <msq) r=m-1;
            else l=m+1;
        }
        return 0;
    }
}