class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;
        for(int i=0; i<n; i++) {
            mx = Math.max(nums[i], mx);
            prefixGcd[i] = gcd(mx, nums[i]);
        }
        Arrays.sort(prefixGcd);
        int i=0, j=n-1;
        long sum = 0;
        while(i < j) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
}