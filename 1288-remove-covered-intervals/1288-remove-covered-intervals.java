class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int cnt = 1;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int a=intervals[0][0], b=intervals[0][1];
        for(int[] in : intervals) {
            if(!(in[0] >= a && in[1] <= b)) {
                a = in[0];
                b = in[1];
                cnt++;
            } 
        }
        return cnt;
    }
}