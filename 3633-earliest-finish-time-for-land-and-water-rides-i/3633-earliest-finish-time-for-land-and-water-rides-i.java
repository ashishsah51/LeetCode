class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m = landStartTime.length, n = waterStartTime.length;
        int min = 100000;
        
        for(int i=0; i<m; i++) {
            int endTime = landStartTime[i] + landDuration[i];
            for(int j=0; j<n; j++) {
                if(waterStartTime[j] <= endTime) {
                    min = Math.min(min, endTime + waterDuration[j]);
                } else {
                    min = Math.min(min, endTime + waterDuration[j] + (waterStartTime[j] - endTime));
                }
            }
        }


        for(int i=0; i<n; i++) {
            int endTime = waterStartTime[i] + waterDuration[i];
            for(int j=0; j<m; j++) {
                if(landStartTime[j] <= endTime) {
                    min = Math.min(min, endTime + landDuration[j]);
                } else {
                    min = Math.min(min, endTime + landDuration[j] + (landStartTime[j] - endTime));
                }
            }
        }

        return min;

    }
}