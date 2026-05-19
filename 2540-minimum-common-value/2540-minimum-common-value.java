class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int res = Integer.MAX_VALUE;

        for(int num : nums1) {
            if(set.contains(num)) {
                res = Math.min(num, res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}