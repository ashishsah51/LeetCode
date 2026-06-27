public class Solution {

    void add(int i, int v, int[] ft, int lenn) {
        i++;
        while (i <= lenn) {
            ft[i] += v;
            i += i & -i;
        }
    }

    long sum(int i, int[] ft) {
        i++;
        long s = 0;
        while (i > 0) {
            s += ft[i];
            i -= i & -i;
        }
        return s;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = (nums[i] == target) ? 1 : -1;
        int len = n;
        int[] ft = new int[2 * n + 2];
        long ans = 0;
        int cur = 0;
        add(cur + len, 1, ft, 2 * n + 1);

        for (int x : nums) {
            cur += x;
            int q = cur + len - 1;
            if (q >= 0) ans += sum(Math.min(q, 2 * n), ft);
            add(cur + len, 1, ft, 2 * n + 1);
        }
        return ans;
    }
}
