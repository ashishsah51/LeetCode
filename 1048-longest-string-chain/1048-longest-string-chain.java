class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b)-> a.length() - b.length());
        int[] dp = new int[n];
        int max =0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(isPredecessor(words[i], words[j]))
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    boolean isPredecessor(String a, String b) {
        int an = a.length(), bn = b.length();
        if(Math.abs(an-bn)!=1) return false;
        int diff = 0, i=0, j=0;
        while(i<an && j<bn) {
            if(a.charAt(i)!=b.charAt(j)) {
                if(an > bn) i++;
                else j++;
                diff++;
            } else {
                i++;
                j++;
            }
        }
        return diff <= 1;
    }
}