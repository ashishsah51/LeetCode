class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int tc = 0, cnt = 0;
        for(int cost : costs) {
            if(tc + cost <= coins) {
                tc += cost;
                cnt++;
            } else break;
        }
        return cnt;
    }
}