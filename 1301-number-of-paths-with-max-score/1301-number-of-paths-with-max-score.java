class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        long[][][] dp = new long[n][n][2];
        dp[n-1][n-1][0] = 1;
        dp[n-1][n-1][1] = 0;
        
        for(int i=n-2; i>=0; i--) {
            if(board.get(i).charAt(n-1) == 'X') {
                break;
            }
            dp[i][n-1][0] = 1;
            dp[i][n-1][1] = dp[i+1][n-1][1] + (board.get(i).charAt(n-1) - '0' +0l);
        }

        for(int j=n-2; j>=0; j--) {
            if(board.get(n-1).charAt(j) == 'X') {
                break;
            }
            dp[n-1][j][0] = 1;
            dp[n-1][j][1] = dp[n-1][j+1][1] + (board.get(n-1).charAt(j) - '0' + 0l);
        }
        int MOD = (int)(1e9) + 7;
        for(int i=n-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(board.get(i).charAt(j) == 'X') continue;
                long max = Math.max(dp[i+1][j+1][1], Math.max(dp[i][j+1][1], dp[i+1][j][1]));
                long way = Math.max(dp[i+1][j+1][0], Math.max(dp[i][j+1][0], dp[i+1][j][0]));
                if(way == 0) continue;
                if(max == dp[i+1][j+1][1]) {
                    dp[i][j][0] = (dp[i+1][j+1][0]) % MOD;
                }
                if(max == dp[i+1][j][1]) {
                    dp[i][j][0] =  (dp[i][j][0] + dp[i+1][j][0]) % MOD;
                }
                if(max == dp[i][j+1][1]) {
                    dp[i][j][0] =  (dp[i][j][0] + dp[i][j+1][0]) % MOD;
                }
                if(i==0 && j==0) {
                    dp[i][j][1] = max;
                } else {
                    dp[i][j][1] += (max + board.get(i).charAt(j)-'0');
                }
                // System.out.println(i+" "+j+" "+dp[i][j][0]+" "+dp[i][j][1]);
            }
        }
        return new int[]{(int)(dp[0][0][1]), (int)(dp[0][0][0])};
    }
}