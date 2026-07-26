class Solution {
    public int maxProduct(int n) {
        int d1=0, d2=0;
        while(n>0) {
            int d = n%10;
            if(d1 < d) {
                d2 = d1;
                d1 = d;
            } else if(d2 < d) {
                d2 = d;
            }
            n /= 10;
        }
        return d1*d2;
    }
}