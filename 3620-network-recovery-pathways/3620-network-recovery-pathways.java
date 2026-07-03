class Solution {
    List<List<int[]>> adj;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        long l=(int)(1e9), r=0;
        long res = -1;
        int n = online.length;
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges) {
            l = Math.min(e[2], l);
            r = Math.max(e[2], r);
            adj.get(e[0]).add(new int[]{e[1], e[2], online[e[1]]?1:0});
        }
        System.out.println(l+" "+r);
        while(l<=r) {
            long mid = (l + r) / 2;
            if(check(mid, k, n)) {
                res = mid;
                l = mid+1;
            } else r = mid-1;
        }
        return (int)res;
    }
    boolean check(long tr, long k, int n) {
        long[] dis = new long[n];
        long INF = Long.MAX_VALUE;
        Arrays.fill(dis, INF);
        dis[0] = 0l;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            if(dis[curr[0]] < curr[1]) continue;

            for(int[] nbr : adj.get(curr[0])) {
                int newCost = nbr[1] + curr[1];
                if(nbr[2]==0 || nbr[1] < tr) continue;
                if(dis[nbr[0]] > newCost) {
                    dis[nbr[0]] = newCost;
                    pq.add(new int[]{nbr[0], newCost});
                }
            }
        }
        return dis[n-1] <= k;
    }
}