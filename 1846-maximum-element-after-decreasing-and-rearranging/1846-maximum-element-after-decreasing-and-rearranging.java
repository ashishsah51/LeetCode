class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int res = 1, prev = 1;
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