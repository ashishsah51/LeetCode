class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 0;
        for(int x : arr) {
            if(x-prev <= 1) {
                prev = x;
            } else {
                prev++;
            }
        }
        return prev;
    }
}