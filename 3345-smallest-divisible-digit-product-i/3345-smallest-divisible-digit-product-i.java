class Solution {
    public int smallestNumber(int n, int t) {
        while(true) {
            if(product(n)%t == 0) return n;
            n++;
        }
    }
    int product(int n) {
        int tm = 1;
        while(n>0) {
            tm = tm * (n%10);
            n = n/10;
        }
        return tm;
    }
}