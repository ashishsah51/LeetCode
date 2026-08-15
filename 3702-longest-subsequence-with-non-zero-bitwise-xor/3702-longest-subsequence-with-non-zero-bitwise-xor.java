class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length, xor = 0;
        boolean hasPositiveValue = false;
        for(int num : nums) {
            xor = xor ^ num;
            if(num > 0) hasPositiveValue = true;
        }
        if(!hasPositiveValue) return 0;
        return xor == 0 ? n-1 : n;
    }
}