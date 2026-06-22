class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] frq = new int[26];
        for(char c : text.toCharArray()) {
            frq[c-'a']++;
        }
        int res = 100000;
        
        res = Math.min(res, frq[0]);
        res = Math.min(res, frq[1]);
        res = Math.min(res, frq['l'-'a']/2);
        res = Math.min(res, frq['o'-'a']/2);
        res = Math.min(res, frq['n'-'a']);
        return res;
    }
}