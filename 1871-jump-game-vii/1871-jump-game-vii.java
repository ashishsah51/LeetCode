class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int idx = 0, n = s.length();
        char[] ch = s.toCharArray();
        ch[0]='2';
        for(int i=0; i<n; i++) {
            if(ch[i]!='2') continue;
            for(int j=Math.max(i+minJump, idx); j<=Math.min(n-1, i+maxJump); j++) {
                if(s.charAt(j)=='0') ch[j]='2';
            }
            idx = Math.min(n-1, i+maxJump);
        }
        return ch[n-1]=='2';
    }
}