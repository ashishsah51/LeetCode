class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[][] set = new boolean[26][2];
        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                set[c-'a'][0] = true;
            } else {
                set[c-'A'][1] = true;
            }
        }

        int cnt = 0;
        for(int i=0; i<26; i++) {
            if(set[i][0] && set[i][1]) cnt++;
        }

        return cnt;
    }
}