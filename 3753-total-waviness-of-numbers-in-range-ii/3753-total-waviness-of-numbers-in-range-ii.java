class Solution {

    class Node {
        long waviness;
        long cnt;

        Node(long waviness, long cnt) {
            this.waviness = waviness;
            this.cnt = cnt;
        }
    }

    private Node[][][][][] dp;
    private String s;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) {
            return 0;
        }

        s = String.valueOf(n);
        dp = new Node[17][2][2][11][11];

        return dfs(0, 1, 1, 10, 10).waviness;
    }

    private Node dfs(int pos,
                     int tight,
                     int leadingZero,
                     int prev1,
                     int prev2) {

        if (pos == s.length()) {
            return new Node(0, 1);
        }

        if (tight == 0 &&
            dp[pos][0][leadingZero][prev1][prev2] != null) {
            return dp[pos][0][leadingZero][prev1][prev2];
        }

        long totalWaviness = 0;
        long totalCount = 0;

        int limit = (tight == 1)
                ? s.charAt(pos) - '0'
                : 9;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight =
                    (tight == 1 && digit == limit) ? 1 : 0;

            if (leadingZero == 1 && digit == 0) {

                Node child =
                        dfs(pos + 1,
                            nextTight,
                            1,
                            10,
                            10);

                totalWaviness += child.waviness;
                totalCount += child.cnt;

            } else {

                long add = 0;
                int nextPrev1;
                int nextPrev2;

                if (leadingZero == 1) {

                    nextPrev1 = digit;
                    nextPrev2 = 10;

                } else {

                    if (prev2 != 10) {

                        boolean peak =
                                prev1 > prev2 &&
                                prev1 > digit;

                        boolean valley =
                                prev1 < prev2 &&
                                prev1 < digit;

                        if (peak || valley) {
                            add = 1;
                        }
                    }

                    nextPrev2 = prev1;
                    nextPrev1 = digit;
                }

                Node child =
                        dfs(pos + 1,
                            nextTight,
                            0,
                            nextPrev1,
                            nextPrev2);

                totalWaviness +=
                        child.waviness +
                        add * child.cnt;

                totalCount += child.cnt;
            }
        }

        Node ans = new Node(totalWaviness, totalCount);

        if (tight == 0) {
            dp[pos][0][leadingZero][prev1][prev2] = ans;
        }

        return ans;
    }
}