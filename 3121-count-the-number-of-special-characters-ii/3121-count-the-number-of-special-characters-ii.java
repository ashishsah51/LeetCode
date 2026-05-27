class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        Set<Character> res = new HashSet<>();
        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                char uc = (char)(c-'a'+'A');
                if(res.contains(c)) res.remove(c);
                if(!set.contains(uc)) res.add(c);
            } else {
                set.add(c);
            }
        }
        for(char c='a'; c<='z'; c++) {
            char uc = (char)(c-'a'+'A');
            if(!set.contains(uc) && res.contains(c)) res.remove(c); 
        }
        return res.size();
    }
}