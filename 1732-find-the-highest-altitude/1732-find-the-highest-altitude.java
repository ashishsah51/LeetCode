class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, sum = 0;
        for(int g : gain) {
            sum += g;
            max = Math.max(max, sum);
        }
        return max;
    }
}