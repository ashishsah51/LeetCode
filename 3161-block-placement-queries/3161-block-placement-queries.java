class Solution {
    private final int MAX_RANGE = 50000;
    private int[] seg;
    public List<Boolean> getResults(int[][] queries) {
        seg = new int[4 * (MAX_RANGE + 1)];

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        for(int[] q : queries) {
            if(q[0]==1) obstacles.add(q[1]);
        }

        List<Integer> pos = new ArrayList<>(obstacles);

        for(int i=1; i<pos.size(); i++) {
            update(1, 0, MAX_RANGE, pos.get(i), pos.get(i)-pos.get(i-1));
        }

        List<Boolean> ans = new ArrayList<>();

        for(int i=queries.length - 1; i>=0; i--) {
            if(queries[i][0] == 1) {
                int x = queries[i][1];
                Integer leftPos = obstacles.lower(x);
                // update(1, 0, MAX_RANGE, x, 0);
                Integer rightPos = obstacles.higher(x);

                if(rightPos != null) {
                    update(1, 0, MAX_RANGE, rightPos, rightPos - leftPos);
                }
                obstacles.remove(x);
            } else {
                int x = queries[i][1];
                int sz = queries[i][2];

                int prevObstacle = obstacles.floor(x);

                int best = query(1, 0, MAX_RANGE, 0, prevObstacle);
                best = Math.max(best, x-prevObstacle);
                ans.add(best >= sz);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if(ql > r || qr < l) return 0;
        if(ql <= l && r <= qr) {
            return seg[node];
        }

        int mid = (l + r) / 2;

        return Math.max(
            query(2*node, l, mid, ql, qr),
            query(2*node+1, mid+1, r, ql, qr)
        );
    }

    private void update(int node, int l, int r, int idx, int val) {
        if(l==r) {
            seg[node] = val;
            return;
        }

        int mid = (l+r)/2;

        if(idx <= mid) {
            update(2*node, l, mid, idx, val);
        } else {
            update(2*node+1, mid+1, r, idx, val);
        }
        seg[node] = Math.max(seg[2*node], seg[2*node+1]);
    }
}