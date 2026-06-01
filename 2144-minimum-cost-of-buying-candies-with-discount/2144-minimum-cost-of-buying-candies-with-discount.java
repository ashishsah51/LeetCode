class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int j=cost.length-1;
        int totalCost = 0;
        while(j>=2) {
            totalCost += cost[j];
            totalCost += cost[j-1];
            j-=3;
        }
        while(j>=0) totalCost += cost[j--];
        return totalCost;
    }
}