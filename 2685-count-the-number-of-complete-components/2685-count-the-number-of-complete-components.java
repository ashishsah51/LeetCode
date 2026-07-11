class Solution {
    List<List<Integer>> adj;
    boolean flag;
    int compCnt;
    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(vis[i]) continue;
            flag = true;
            compCnt = 0;
            dfs(i, vis, adj.get(i).size());
            cnt +=  (flag && adj.get(i).size()==compCnt-1) ? 1 : 0;
        }
        return cnt;
    }

    void dfs(int src, boolean[] vis, int ec) {
        vis[src] = true;
        compCnt++;
        flag = flag && adj.get(src).size() == ec;
        for(int nbr : adj.get(src)) {
            if(vis[nbr]) continue;
            dfs(nbr, vis, ec);
        }
    }
}