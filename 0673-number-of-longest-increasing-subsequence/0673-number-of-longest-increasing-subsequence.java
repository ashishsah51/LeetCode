class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0, cnt=0;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0]);
            }
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j] && dp[i][0] == dp[j][0])
                    dp[i][1]+=dp[j][1];
            }
            dp[i][0] += 1;
            dp[i][1] = Math.max(dp[i][1], 1);
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        for(int[] x : dp) {
            if(maxLen == x[0]) cnt += x[1];
        }
        return cnt;
    }
}