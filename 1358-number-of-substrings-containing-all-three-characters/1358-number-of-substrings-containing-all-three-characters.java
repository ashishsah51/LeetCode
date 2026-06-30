class Solution {
    public int numberOfSubstrings(String s) {
        int pa=-1, pb=-1, pc=-1;
        int n = s.length(), ans=0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='a') pa=i;
            else if(s.charAt(i)=='b') pb=i;
            else pc=i;
            int min = Math.min(pa, Math.min(pb, pc));
            ans += (min+1);
        }
        return ans;
    }
}