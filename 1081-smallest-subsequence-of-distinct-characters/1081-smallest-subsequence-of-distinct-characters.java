class Solution {
    int idx;
    Set<Character> set;
    public String smallestSubsequence(String s) {
        set = new HashSet<>();

        for(char c : s.toCharArray()) {
            set.add(c);
        }

        int uniqueCnt = set.size();

        idx = 0;
        int n=s.length();
        char[] res = new char[uniqueCnt];

        for(int i=0; i<uniqueCnt; i++) {
            for(char c='a'; c<='z'; c++) {
                if(set.contains(c) && canAdd(c, s, n)) {
                    res[i] = c;
                    set.remove(c);
                    break;
                }
            }
        }
        return String.valueOf(res);
    }

    boolean canAdd(char c, String s, int n) {
        int i = idx;
        // System.out.print(c+" "+i);
        while(i<n && s.charAt(i)!=c) i++;
        // System.out.println(" "+i);
        int tm = i;
        Set<Character> tmp = new HashSet<>();
        while(i<n) {
            tmp.add(s.charAt(i));
            i++;
        }

        for(char x : set) {
            if(!tmp.contains(x)) return false;
        } 

        idx = tm+1;
        return true;
    }
}

