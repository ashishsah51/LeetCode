class Solution {
    public String smallestPalindrome(String s) {
        int[] frq = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch) {
            frq[c-'a']++;
        }

        char odd = ' ';
        int i=0, j=s.length()-1;
        for(int k=0; k<26; k++) {
            char c = (char)(k+'a');
            if(frq[k]%2==1) {
                odd = c;
                frq[k]--;
            } 
            while(frq[k]>0) {
                ch[i] = c;
                ch[j] = c;
                i++;
                j--;
                frq[k]-=2;
            }
        }
        if(i==j) ch[i] = odd;
        return String.valueOf(ch);
    }
}