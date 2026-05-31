class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // gain[i] = total items obtained
        // when buying the FIRST copy of item i
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // factor[i] divides factor[j]
                if (items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        // dp[i][b]
        // Maximum items obtainable using first i item types
        // with budget b
        int[][] dp = new int[n + 1][budget + 1];

        int answer = 0;

        for (int i = 0; i < n; i++) {

            int price = items[i][1];

            // Budgets smaller than price
            for (int b = 0; b < price && b <= budget; b++) {
                dp[i + 1][b] = Math.max(dp[i + 1][b], dp[i][b]);
            }

            for (int b = price; b <= budget; b++) {

                // Option 1:
                // First purchase of this item
                dp[i + 1][b] = Math.max(
                    dp[i + 1][b],
                    dp[i][b - price] + gain[i]
                );

                // Option 2:
                // Additional purchases of same item
                dp[i + 1][b] = Math.max(
                    dp[i + 1][b],
                    dp[i + 1][b - price] + 1
                );

                // Option 3:
                // Skip current item
                dp[i + 1][b] = Math.max(
                    dp[i + 1][b],
                    dp[i][b]
                );

                answer = Math.max(answer, dp[i + 1][b]);
            }
        }

        return answer;
    }
}