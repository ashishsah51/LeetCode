class Solution {
    Boolean[] dp;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        dp = new Boolean[n];
        return solve(start, arr, n);
    }
    boolean solve(int src, int[] arr, int n) {
        if(src < 0 || src >= n) return false;
        if(arr[src]==0) return true;
        if(dp[src]!=null) return dp[src];
        dp[src] = false;
        dp[src] = dp[src] || solve(src+arr[src], arr, n) || solve(src-arr[src], arr, n);
        return dp[src];
    }
}