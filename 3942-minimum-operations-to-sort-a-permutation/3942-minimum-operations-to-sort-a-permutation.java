class Solution {
    final int INF = Integer.MAX_VALUE;
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(isAlredySorted(nums, n)) return 0;
        int zeroIdx = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                zeroIdx = i;
                break;
            }
        }

        int min = Math.min(rCheck(nums, n, zeroIdx), fCheck(nums, n, zeroIdx));
        return min==INF?-1:min;
        
    }
    boolean isAlredySorted(int[] nums, int n) {
        for(int i=0; i<n; i++) if(nums[i]!=i) return false;
        return true;
    }
    int rCheck(int[] nums, int n, int zeroIdx) {
        int tm = n-1;
        for(int i=zeroIdx+1; i<n; i++) {
            if(nums[i]!=tm) return INF;
            tm--;
        }
        for(int i=0; i<zeroIdx; i++) {
            if(nums[i]!=tm) return INF;
            tm--;
        }

        int revfirst = n - zeroIdx;
        return Math.min(zeroIdx+2, n-zeroIdx);
    }

    int fCheck(int[] nums, int n, int zeroIdx) {
        int tm = 0;
        for(int i=zeroIdx; i<n; i++) {
            if(nums[i]!=tm) return INF;
            tm++;
        }
        for(int i=0; i<zeroIdx; i++) {
            if(nums[i]!=tm) return INF;
            tm++;
        }

        int revfirst = n - zeroIdx;
        return Math.min(zeroIdx, n-zeroIdx+2);
    }
}