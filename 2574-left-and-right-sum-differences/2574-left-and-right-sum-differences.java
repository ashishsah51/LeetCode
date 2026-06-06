class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rSum = Arrays.stream(nums).sum();
        int n = nums.length;
        int lSum = 0;
        for(int i=0; i<n; i++) {
            int num = nums[i];
            rSum -= num;
            nums[i] = Math.abs(lSum - rSum);
            lSum += num;
        }
        return nums;
    }
}