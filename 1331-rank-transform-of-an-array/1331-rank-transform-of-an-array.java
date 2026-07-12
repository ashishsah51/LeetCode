class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        TreeSet<Integer> set = Arrays.stream(arr)
                                    .boxed()
                                    .collect(Collectors.toCollection(TreeSet::new));
        int rank=1;
        Map<Integer, Integer> map= new HashMap<>();

        for(int x : set) {
            map.put(x, rank);
            rank++;
        }

        for(int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}