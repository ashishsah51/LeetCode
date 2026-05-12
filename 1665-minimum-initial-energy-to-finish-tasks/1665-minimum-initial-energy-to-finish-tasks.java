class Solution {

    public int minimumEffort(int[][] tasks) {

        int n = tasks.length;

        /*
            arr[i][0] = actual energy required to complete task
            arr[i][1] = minimum energy needed to start task
            arr[i][2] = extra energy requirement
                        = minimum - actual
        */
        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {

            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];

            // Difference helps prioritize harder tasks first
            arr[i][2] = tasks[i][1] - tasks[i][0];
        }

        /*
            Sort tasks by:
            1. Larger (minimum - actual) first
            2. If equal, larger minimum energy first

            Why?
            We should perform tasks requiring higher reserved
            energy earlier to minimize initial energy needed.
        */
        Arrays.sort(arr, (a, b) -> {

            if(a[2] == b[2]) {
                return b[1] - a[1];
            }

            return b[2] - a[2];
        });

        /*
            Lower Bound:
            At least maximum minimum-energy task required

            Upper Bound:
            Sum of all actual costs + max minimum energy
        */
        int maxMinEnergy = 0;
        int totalActualEnergy = 0;

        for(int[] task : tasks) {

            maxMinEnergy =
                Math.max(maxMinEnergy, task[1]);

            totalActualEnergy += task[0];
        }

        int left = maxMinEnergy;
        int right = totalActualEnergy + maxMinEnergy;

        int answer = right;

        /*
            Binary Search on answer:
            Find minimum starting energy that can
            complete all tasks.
        */
        while(left <= right) {

            int mid =
                left + (right - left) / 2;

            if(canCompleteAllTasks(mid, arr)) {

                answer = mid;

                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }

        return answer;
    }

    /*
        Check whether current starting energy
        is sufficient to complete all tasks.
    */
    boolean canCompleteAllTasks(
        int energy,
        int[][] arr
    ) {

        for(int[] task : arr) {

            int actual = task[0];
            int minimum = task[1];

            // Cannot even start this task
            if(energy < minimum) {
                return false;
            }

            // Consume actual energy
            energy -= actual;
        }

        return true;
    }
}