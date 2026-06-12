import java.util.*;

class Solution {

    int MOD = 1000000007;

    List<Integer>[] adj;

    int[][] up;
    int[] depth;

    int LOG = 17;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        LOG = 18;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, -1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int lca = getLCA(u, v);

            int distance =
                    depth[u]
                    + depth[v]
                    - 2 * depth[lca];

            ans[i] = (int) modPow(2, distance - 1);
        }

        return ans;
    }

    private void dfs(int node, int parent) {

        up[node][0] = parent;

        for (int j = 1; j < LOG; j++) {

            if (up[node][j - 1] == -1) {
                up[node][j] = -1;
            } else {
                up[node][j] =
                        up[up[node][j - 1]][j - 1];
            }
        }

        for (int nbr : adj[node]) {

            if (nbr == parent) {
                continue;
            }

            depth[nbr] = depth[node] + 1;

            dfs(nbr, node);
        }
    }

    private int getLCA(int a, int b) {

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int j = LOG - 1; j >= 0; j--) {

            if ((diff & (1 << j)) != 0) {
                a = up[a][j];
            }
        }

        if (a == b) {
            return a;
        }

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[a][j] != up[b][j]) {

                a = up[a][j];
                b = up[b][j];
            }
        }

        return up[a][0];
    }

    private long modPow(long base, long exp) {

        long ans = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;

            exp >>= 1;
        }

        return ans;
    }
}