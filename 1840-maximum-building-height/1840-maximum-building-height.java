class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int prevHt=0, prevPos = 1, maxHt = 0;
        int len = restrictions.length;
        for(int i=len-1; i>=1; i--) {
            if(restrictions[i-1][1] > restrictions[i][1]+(restrictions[i][0] - restrictions[i-1][0])) {
                restrictions[i-1][1] = restrictions[i][1] + (restrictions[i][0] - restrictions[i-1][0]);
            }
        }
        for(int[] res : restrictions) {
            int thresholdHt = res[1], currPos = res[0];
            int maxHtBuildOnId = prevHt + (currPos - prevPos);
            if(maxHtBuildOnId <= thresholdHt) {
                prevHt = maxHtBuildOnId;
            } else {
                int gap = 0;
                if(thresholdHt  >= prevHt) {
                    gap = ((currPos - prevPos) + prevHt) - thresholdHt;
                    gap = gap/2;
                    maxHtBuildOnId = thresholdHt + gap;
                } else {
                    gap = (currPos - prevPos) - (prevHt - thresholdHt);
                    gap = gap / 2;
                    maxHtBuildOnId = prevHt + gap;
                }
                prevHt = thresholdHt;
            }
            maxHt = Math.max(maxHtBuildOnId, maxHt);
            prevPos = currPos;
            // System.out.println(prevPos+ " " + prevHt + " "+maxHtBuildOnId);
        }
        maxHt = Math.max((n - prevPos) + prevHt, maxHt);
        return maxHt;
    }
}

// 3, 2 -> 10 : threshold = 6
// 2 3 4 5 6 7 6 6
// 3, 3 -> 10 : threshold = 6
// 3 4 5 6 7 8 7 6

// 3, 8 -> 10 : threshold = 3
// 8 9 8 7 6 5 4 3

// 3, 8 -> 20 : threshold = 3
// 8 9 8 7 6 5 4 3