class Solution {
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[][] tm = new int[n][2];
        for(int i=0; i<n; i++) {
            tm[i][0] = arr[i];
            tm[i][1] = i;
        }
        Arrays.sort(tm, (a, b) -> a[0] - b[0]);
        int res = 0;
        dp = new Integer[n];
        for(int i=0; i<n; i++) {
            res = Math.max(res, solve(i, arr, d));
        }
        return res;
    }
    int solve(int src, int[] arr, int d) {
        int n = arr.length;
        if(dp[src]!=null) return dp[src];
        int ans = 1;
        for(int i=src+1; i<Math.min(n, src+d+1); i++) {
            if(arr[src] <= arr[i]) break;
            ans = Math.max(solve(i, arr, d)+1, ans);
        }
        for(int i=src-1; i>=Math.max(0, src-d); i--) {
            if(arr[src] <= arr[i]) break;
            ans = Math.max(solve(i, arr, d)+1, ans);
        }
        return dp[src] = ans;
    }
}