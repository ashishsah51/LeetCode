import java.util.*;

class Solution {

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Pair(nums[i], i);

        Arrays.sort(arr, Comparator.comparingInt(a -> a.val));

        // original index -> sorted position
        int[] pos = new int[n];

        for (int i = 0; i < n; i++)
            pos[arr[i].idx] = i;

        // far[i] = farthest position reachable in one edge
        int[] far = new int[n];

        int j = 0;

        for (int i = 0; i < n; i++) {

            while (j + 1 < n &&
                    arr[j + 1].val - arr[i].val <= maxDiff)
                j++;

            far[i] = j;
        }

        int LOG = 20;

        int[][] jump = new int[LOG][n];

        for (int i = 0; i < n; i++)
            jump[0][i] = far[i];

        for (int k = 1; k < LOG; k++) {

            for (int i = 0; i < n; i++) {

                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (jump[LOG - 1][u] < v) {
                ans[q] = -1;
                continue;
            }

            int cur = u;
            int edges = 0;

            for (int k = LOG - 1; k >= 0; k--) {

                if (jump[k][cur] < v) {

                    cur = jump[k][cur];
                    edges += (1 << k);
                }
            }

            ans[q] = edges + 1;
        }

        return ans;
    }
}