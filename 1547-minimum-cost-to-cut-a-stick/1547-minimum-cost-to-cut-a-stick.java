class Solution {
    Map<String, Long> dp;
    final int INF = Integer.MAX_VALUE;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp = new HashMap<>();
        return (int)solve(0, n, cuts);
    }
    long solve(int l, int r, int[] cuts) {
        if(l>=r) return 0;
        String key = l + "," + r;
        if(dp.containsKey(key)) return dp.get(key);
        long ans = INF;
        boolean flag = false;
        for(int cut : cuts) {
            if(cut > l && cut < r) {
                flag = true;
                long val = solve(l, cut, cuts) + solve(cut, r, cuts) + (r-l);
                ans = Math.min(ans, val);
            }
        }
        if(!flag) ans = 0;
        dp.put(key, ans);
        return ans;
    }
}