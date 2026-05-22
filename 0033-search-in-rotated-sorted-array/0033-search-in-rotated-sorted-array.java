class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0, r=n-1;

        while(l<=r) {
            int mid = (l+r)/2;
            System.out.println(l+" "+mid+" "+r);
            if(nums[mid] == target) return mid;
            // left half sorted
            if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && nums[mid] > target) r = mid-1;
                else l = mid+1;           
            } else { // right half sorted
                if(nums[mid] < target && nums[r] >= target) l = mid+1;
                else r = mid-1;
            }
        }
        return -1;
    }
}