class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        /*
            diff[x] stores how moves change
            for target sum x
        */
        int[] diff = new int[2 * limit + 2];

        for(int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b) + 1;

            int high = Math.max(a, b) + limit;

            int sum = a + b;

            /*
                Initially assume 2 moves needed
                for every possible sum
            */

            // Reduce to 1 move
            diff[low]--;

            // Reduce to 0 move at exact sum
            diff[sum]--;

            // Back to 1 move after exact sum
            diff[sum + 1]++;

            // Back to 2 moves after high
            diff[high + 1]++;
        }

        int pairs = n / 2;

        int answer = Integer.MAX_VALUE;

        /*
            Initially all sums require:
            2 * pairs moves
        */
        int moves = 2 * pairs;

        for(int target = 2; target <= 2 * limit; target++) {

            moves += diff[target];

            answer = Math.min(answer, moves);
        }

        return answer;
    }
}