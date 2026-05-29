class Solution {
    public int minElement(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for(int num : nums) {
            minNum = Math.min(minNum, getDigitSum(num));
        }
        return minNum;
    }
    int getDigitSum(int num) {
        int sum = 0;
        for(char c : String.valueOf(num).toCharArray()) {
            sum += (c-'0');
        }
        return sum;
    }
}