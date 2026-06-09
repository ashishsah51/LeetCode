class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return (max - min) * 1l * k;
    }
}