class Solution {
    int[] rank, par;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        rank = new int[n];
        par = new int[n];
        for(int i=0; i<n; i++) par[i] = i;
        for(int i=1; i<n; i++) {
            if(nums[i] - nums[i-1] <= maxDiff) union(i, i-1);
        }

        int qlen = queries.length;
        boolean[] ans = new boolean[qlen];
        for(int i=0; i<qlen; i++) {
            if(find(queries[i][0]) == find(queries[i][1])) ans[i] = true;
        }
        return ans;
    }
    int find(int x) {
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    void union(int a, int b) {
        int fx = find(a);
        int fy = find(b);
        if(fx == fy) return;
        if(rank[fx] > rank[fy]) {
            par[fy] = fx;
        } else if(rank[fx] < rank[fy]) {
            par[fx] = fy;
        } else {
            par[fy] = fx;
            rank[fx]++;
        }
    }
}