class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int pivotCnt = 0;
        int j=0;
        for(int i=0; i<n; i++) {
            if(nums[i] < pivot) {
                res[j] = nums[i];
                j++;
            } else if(nums[i]==pivot) pivotCnt++;
        }

        while(pivotCnt > 0) {
            res[j] = pivot;
            pivotCnt--;
            j++;
        }

        for(int i=0; i<n; i++) {
            if(nums[i] > pivot) {
                res[j] = nums[i];
                j++;
            }
        }

        return res;
    }
}