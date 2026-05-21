class Solution {
    class Trie {
        Trie[] child;
        Trie() {
            child = new Trie[10];
        }
    }
    Trie root;
    void insert(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        Trie curr = root;
        for(char c : ch) {
            if(curr.child[c-'0']==null) {
                curr.child[c-'0'] = new Trie();
            }
            curr = curr.child[c-'0'];
        }
    } 
    int getMaxCommonPrefixLength(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int len = 0;
        Trie curr = root;
        for(char c : ch) {
            if(curr.child[c-'0']==null) break;
            curr = curr.child[c-'0'];
            len++;
        }
        return len;
    } 
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new Trie();
        for(int a : arr1) insert(a);
        int maxLen = 0;
        for(int a : arr2) maxLen = Math.max(maxLen, getMaxCommonPrefixLength(a));
        return maxLen;
    }
}