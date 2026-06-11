class Solution {
    public int assignEdgeWeights(int[][] edges) {
        long res = 0l;
        int mod = (int)(1e9) + 7;
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i=0; i<=n+1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e :edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int root = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+2];
        q.add(1);
        vis[1] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.remove();
                for(int nbr : adj.get(curr)) {
                    if(!vis[nbr]) {
                        q.add(nbr);
                        vis[nbr] = true;
                    }

                }
            }
            if(!q.isEmpty()) {
                res = res==0 ? 1 : (res * 2) % mod;
            }
        }
        return (int)res;
    }
}