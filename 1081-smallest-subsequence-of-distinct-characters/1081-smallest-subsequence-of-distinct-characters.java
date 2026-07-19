class Solution {
    int idx;
    Set<Character> set;
    public String smallestSubsequence(String s) {

        int[] frq = new int[26];
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()) frq[c-'a']++;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                frq[s.charAt(i)-'a']--;
                continue;
            }
            // System.out.print(s.charAt(i)+" ");
            while(!stk.isEmpty() && s.charAt(i)<=stk.peek() && frq[stk.peek()-'a']>0) {
                // System.out.print(stk.peek()+" ");
                char ch = stk.pop();
                int val = map.get(ch);
                if(val==1) map.remove(ch);
                else map.put(ch, val-1);
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1); 
            stk.push(s.charAt(i));
           // System.out.println(stk.toString());
            frq[s.charAt(i)-'a']--;
        }
        int n = stk.size();
        int[][] arr = new int[26][2];
        while(!stk.isEmpty()) {
            char c = stk.pop();
            arr[c-'a'][0] = c-'a';
            arr[c-'a'][1] = n+2;
            n--;  
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(arr[i][1]!=0) {
                sb.append((char)(arr[i][0]+'a'));
            } 
        }
        return sb.toString();
        // set = new HashSet<>();

        // for(char c : s.toCharArray()) {
        //     set.add(c);
        // }

        // int uniqueCnt = set.size();

        // idx = 0;
        // int n=s.length();
        // char[] res = new char[uniqueCnt];

        // for(int i=0; i<uniqueCnt; i++) {
        //     for(char c='a'; c<='z'; c++) {
        //         if(set.contains(c) && canAdd(c, s, n)) {
        //             res[i] = c;
        //             set.remove(c);
        //             break;
        //         }
        //     }
        // }
        // return String.valueOf(res);
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

