class Solution {
    public boolean check(int[] nums) {
        int n=nums.length, min=nums[0];
        for(int i=1; i<n; i++) {
            min = Math.min(nums[i], min);
        }
        boolean ans = false;
        for(int i=0; i<n; i++) {
            if(nums[i]==min) {
                ans = ans || check(i, nums);
            }
        }
        return ans;
    }
    boolean check(int minIdx, int[] nums) {
        int n=nums.length;
        for(int i=minIdx+1; i<n; i++) {
            if(nums[i]<nums[i-1]) return false;
        }
        int prev = n-1;
        for(int i=0; i<minIdx; i++) {
            if(nums[prev] > nums[i]) return false;
            prev = i;
        }
        return true;
    }
}