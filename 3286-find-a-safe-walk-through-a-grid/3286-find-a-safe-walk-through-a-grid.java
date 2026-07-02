class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        int m = grid.size(), n = grid.get(0).size();
        boolean[][] dp = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, health-grid.get(0).get(0)});
        dp[0][0] = true;

        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            // if(curr[2]==1) continue;
            for(int k=0; k<4; k++) {
                int x = dx[k] + curr[0], y = dy[k] + curr[1];
                if(x>=0&&y>=0&&x<m&&y<n&&!dp[x][y]) {
                    int tm = curr[2] - grid.get(x).get(y);
                    if(tm>=1) {
                        pq.add(new int[]{x, y, tm});
                        dp[x][y] = true;
                    }
                     
                }
            }
        }
        return dp[m-1][n-1];
    }
}