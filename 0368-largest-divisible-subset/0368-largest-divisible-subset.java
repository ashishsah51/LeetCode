class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        int maxIdx = 0, maxVal = 1;
        for(int i=1; i<n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]%nums[j]==0 && dp[i][0] <= dp[j][0]) {
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = j;
                }
            }
            if(maxVal < dp[i][0]) {
                maxVal = dp[i][0];
                maxIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(maxIdx != dp[maxIdx][1]) {
            res.add(nums[maxIdx]);
            maxIdx = dp[maxIdx][1];
        }
        res.add(nums[maxIdx]);
        Collections.reverse(res);
        return res;
    }
}
// 2 3 8 9 27