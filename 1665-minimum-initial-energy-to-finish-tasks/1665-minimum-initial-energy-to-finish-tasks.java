class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = tasks[i][1] - tasks[i][0];
        }
        Arrays.sort(arr, (a,b) -> {
            if(a[2] == b[2]) return b[1] - a[1];
            return b[2] - a[2];
        });

        int max = 0, sum=0;
        for(int[] task : tasks) {
            max = Math.max(task[1], max);
            sum += task[0];
        }

        int l = max, r = sum + max;
        int res = r;
        while(l<=r) {
            int mid = (l + r) / 2;
            System.out.println();
            if(check(mid, arr)) {
                res = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return res;
    }
    boolean check(int energy, int[][] arr) {
        for(int[] a : arr) {
            if(energy < a[1]) return false;
            energy -= a[0];
        }
        return true;
    }
    // boolean check(int energy, int[][] tasks) {
    //     PriorityQueue<int[]> max = new PriorityQueue<>(
    //         (a, b) -> b[1] - a[1]
    //     );

    //     PriorityQueue<int[]> min = new PriorityQueue<>(
    //         (a, b) -> {
    //             if(a[0] == b[0]) return b[1] - a[1];
    //             else return a[0] - b[0];
    //         }
    //     );
    //     int n = tasks.length;
    //     for(int i=0; i<n; i++) {
    //         max.add(new int[]{tasks[i][0], tasks[i][1], i});
    //         min.add(new int[]{tasks[i][0], tasks[i][1], i});
    //     }
    //     Set<Integer> set = new HashSet<>();
    //     System.out.println(energy+" : ");
    //     while(!max.isEmpty() && !min.isEmpty()) {
    //         int[] y = max.peek(), x = min.peek();
    //         if(x[1] <= energy && energy-x[0] >= y[1]) {
    //             set.add(x[2]);
    //             System.out.print(x[2]+" ");
    //             energy -= x[0];
    //         } else if(y[1] <= energy) {
    //             set.add(y[2]);
    //             System.out.print(y[2]+" ");
    //             energy -= y[0];
    //         } else return false;
    //         updatePriortyQueue(max,set);
    //         updatePriortyQueue(min, set);
    //     }
    //     while(!max.isEmpty()) {
    //         if(energy < max.peek()[1]) return false;
    //         energy -= max.peek()[0];
    //         set.add(max.peek()[2]);
    //         updatePriortyQueue(max,set);
    //     }
    //     while(!min.isEmpty()) {
    //         if(energy < min.peek()[1]) return false;
    //         energy -= min.peek()[0];
    //         set.add(min.peek()[2]);
    //         updatePriortyQueue(min,set);
    //     }
    //     System.out.println(energy+" : ");
    //     return true;
    // }
    // void updatePriortyQueue(PriorityQueue<int[]> pq, Set<Integer> set) {
    //     while(!pq.isEmpty() && set.contains(pq.peek()[2])) pq.remove();
    // }
}