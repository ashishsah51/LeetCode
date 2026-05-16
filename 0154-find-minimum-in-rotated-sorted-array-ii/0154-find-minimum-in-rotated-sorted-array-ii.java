class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l=0, r = n-1;
        while(l<r && nums[l]==nums[r]) l++;
        while(l<r) {
            int mid = (l+r)/2;
            if(nums[mid] > nums[n-1]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}