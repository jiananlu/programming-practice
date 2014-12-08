public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        long t=(long)dividend, k=(long)divisor;
        if(t<0){
            sign=0-sign;
            t=0-t;
        }
        if(k<0){
            sign=0-sign;
            k=0-k;
        }
        int d=0, res=0;
        long ok=k; //original divisor
        while(k<t){
            k=k<<1;
            d++;
        }
        while(t>=ok) {
            if(t>=k){
                res+=1<<d;
                t-=k;
            }
            k=k>>1;
            d--;
        }
        if(sign<0)return 0-res;
        return res;
    }
}