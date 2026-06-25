class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int cnt = 0;
        int n = nums.length;
        int[] ps = new int[n+1];
        for(int i=0; i<n; i++) ps[i+1] = ps[i] + (nums[i]==target ? 1 : 0);

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if((j-i+1)/2 < ps[j+1]-ps[i]) cnt++;
            }
        }

        return cnt;
    }
}