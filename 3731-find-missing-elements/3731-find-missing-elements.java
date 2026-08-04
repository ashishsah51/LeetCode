class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int val = nums[0];
        int n = nums.length;
        for(int i=0; i<n; ) {
            if(nums[i] == val) {
                i++;
                val++;
            } else {
                ans.add(val);
                val++;
            }
        }
        return ans;
    }
}