class Solution {
    final int INF = (int)(1e5);
    Map<Integer, List<Integer>> map;
    Set<Integer> duplicate;
    Integer[] dp;
    Set<Integer> set;
    public int minJumps(int[] arr) {
        map = new HashMap<>();
        duplicate = new HashSet<>();
        set = new HashSet<>();
        int n = arr.length;
        dp = new Integer[n];
        for(int i=0; i<n; i++) {
            List<Integer> tm = map.getOrDefault(arr[i], new ArrayList<>());
            tm.add(i);
            map.put(arr[i], tm);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int lvl = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int idx = q.remove();
                if(idx==n-1) return lvl;

                if(!duplicate.contains(arr[idx])) {
                    duplicate.add(arr[idx]);
                    for(int key : map.get(arr[idx])) {
                        if(!set.contains(key)) {
                            q.add(key);
                            set.add(key);
                        }
                    }
                }

                if(idx>0 && !set.contains(idx-1)) {
                    q.add(idx-1);
                    set.add(idx-1);
                }

                if(idx<n-1 && !set.contains(idx+1)) {
                    q.add(idx+1);
                    set.add(idx+1);
                }
            }
            lvl++;
        }
        return lvl;
    }
}
