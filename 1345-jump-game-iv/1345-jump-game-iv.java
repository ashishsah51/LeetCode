class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        // value -> all indices having same value
        Map<Integer, List<Integer>> sameValueIndices =
                new HashMap<>();

        for(int i = 0; i < n; i++) {

            sameValueIndices
                    .computeIfAbsent(arr[i],
                            k -> new ArrayList<>())
                    .add(i);
        }

        Queue<Integer> queue = new LinkedList<>();

        // visited indices
        boolean[] visited = new boolean[n];

        // processed values to avoid repeated traversal
        Set<Integer> processedValues =
                new HashSet<>();

        queue.offer(0);

        visited[0] = true;

        int steps = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int index = queue.poll();

                // reached destination
                if(index == n - 1)
                    return steps;

                // jump to all same value indices
                if(!processedValues.contains(arr[index])) {

                    processedValues.add(arr[index]);

                    for(int nextIndex :
                            sameValueIndices.get(arr[index])) {

                        if(!visited[nextIndex]) {

                            visited[nextIndex] = true;

                            queue.offer(nextIndex);
                        }
                    }
                }

                // move left
                if(index - 1 >= 0 &&
                        !visited[index - 1]) {

                    visited[index - 1] = true;

                    queue.offer(index - 1);
                }

                // move right
                if(index + 1 < n &&
                        !visited[index + 1]) {

                    visited[index + 1] = true;

                    queue.offer(index + 1);
                }
            }

            steps++;
        }

        return -1;
    }
}