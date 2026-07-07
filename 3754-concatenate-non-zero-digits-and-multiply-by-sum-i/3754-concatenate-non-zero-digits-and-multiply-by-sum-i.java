class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        while(n > 0) {
            if(n%10 != 0) sb.append(n%10);
            sum += n%10;
            n = n/10;
        }
        if(sum==0) return 0l;
        return Long.parseLong(sb.reverse().toString()) * sum;
    }
}