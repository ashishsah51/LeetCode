class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int maxFactor = 0;

        // Count occurrences of each factor
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            frequency.put(
                item[0],
                frequency.getOrDefault(item[0], 0) + 1
            );
        }

        // Stores how many factors are divisible by a given factor
        Map<Integer, Integer> divisibleCount = new HashMap<>();

        for (int factor : frequency.keySet()) {

            int count = 0;

            // Visit all multiples of factor
            for (int multiple = factor;
                 multiple <= maxFactor;
                 multiple += factor) {

                if (frequency.containsKey(multiple)) {
                    count += frequency.get(multiple);
                }
            }

            divisibleCount.put(factor, count);
        }

        // Buy cheapest profitable opportunities first
        Arrays.sort(items, (a, b) -> a[1] - b[1]);

        int minPrice = items[0][1];
        int totalItems = 0;

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // Maximum purchases that can still generate freebies
            int profitableCopies =
                divisibleCount.get(factor) - 1;

            if (profitableCopies == 0)
                continue;

            // No longer profitable
            if (price >= 2 * minPrice ||
                budget < price)
                break;

            long requiredBudget =
                1L * profitableCopies * price;

            if (budget >= requiredBudget) {

                budget -= requiredBudget;

                // Purchased + free copies
                totalItems += 2 * profitableCopies;

            } else {

                int canBuy =
                    budget / price;

                totalItems += 2 * canBuy;

                budget -= canBuy * price;
            }
        }

        // Spend remaining budget on cheapest item
        totalItems += budget / minPrice;

        return totalItems;
    }
}