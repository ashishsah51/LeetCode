class Solution {
    List<List<int[]>> adj;
    int res;
    public int minScore(int n, int[][] roads) {
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] r : roads) {
            adj.get(r[0]-1).add(new int[]{r[1]-1, r[2]});
            adj.get(r[1]-1).add(new int[]{r[0]-1, r[2]});
        }
        res = Integer.MAX_VALUE;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // pq.add(new int[]{0, res});
        Set<Integer> vis = new HashSet<>();
        // while(!pq.isEmpty()) {
        //     int[] curr = pq.remove();

        // }
        dfs(0, vis);
        for(int x : vis) {
            for(int[] y : adj.get(x)) res = Math.min(res, y[1]);
        }
        return res;
    }
    void dfs(int src, Set<Integer> vis) {
        vis.add(src);
        for(int[] nbr : adj.get(src)) {
            if(!vis.contains(nbr[0])) {
                res = Math.min(res, nbr[1]);
                dfs(nbr[0], vis);
            }
        }
    }
}