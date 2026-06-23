class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;

        int len = r - l + 1;
        int m = len;

        long[][] prev = new long[m + 1][2];
        long[][] curr = new long[m + 1][2];

        for (int i = 1; i <= m; i++) {
            prev[i][0] = i;
            prev[i][1] = i;
        }

        for (int j = 1; j < n; j++) {

            for (int i = 1; i <= m; i++) {
                curr[i][0] = 0;
                curr[i][1] = 0;
            }

            for (int i = 1; i <= m; i++) {

                if (i == 1) {
                    curr[i][0] =
                        ((prev[m][1] - prev[i][1]) % MOD + MOD) % MOD;

                    curr[i][1] = 0;
                } else {
                    curr[i][0] =
                        (curr[i - 1][0]
                        + ((prev[m][1] - prev[i][1]) % MOD + MOD) % MOD)
                        % MOD;

                    curr[i][1] =
                        (curr[i - 1][1] + prev[i - 1][0]) % MOD;
                }
            }

            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return (int) ((prev[m][0] + prev[m][1]) % MOD);
    }
}