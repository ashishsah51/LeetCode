class Solution {
    final long MOD = (int)(1e9) + 7;
    Long[][][] dp;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new Long[n][201][201];
        return (int)solve(0, 0, 0, nums);
    }
    long solve(int i, int a, int b, int[] nums) {
        if(i==nums.length) {
            if(a==b && a!=0) return 1l;
            return 0l;
        }

        if(dp[i][a][b]!=null) return dp[i][a][b];

        long skip = solve(i+1, a, b, nums) % MOD;
        long seq1 = solve(i+1, gcd(a, nums[i]), b, nums) % MOD;
        long seq2 = solve(i+1, a, gcd(b, nums[i]), nums) % MOD;
        return dp[i][a][b] = (skip+seq1+seq2) % MOD;
    }
    int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
}