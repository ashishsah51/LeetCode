class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            set.add(A[i]);
            int cnt = 0;
            for(int j=0; j<=i; j++) if(set.contains(B[j])) cnt++;
            ans[i] = cnt;
        }
        return ans;
    }
}