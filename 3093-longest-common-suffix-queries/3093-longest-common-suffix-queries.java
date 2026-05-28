class Solution {

    final int INF = Integer.MAX_VALUE;
    class Trie {
        int minLength, index;
        Trie[] child;
        Trie(int minLength, int index) {
            child = new Trie[26];
            this.index = index;
            this.minLength = minLength;
        }
    }

    private void insert(String word, int index) {
        int len = word.length();
        Trie node = root;
        for(int i=len-1; i>=0; i--) {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null) {
                node.child[idx] = new Trie(len, index);
            } 
            if(node.child[idx].minLength > len) {
                node.child[idx].minLength = len;
                node.child[idx].index = index;
            }
            node = node.child[idx];
        }
    }

    private int search(String word) {
        Trie node = root;
        int index = -1;
        for(int i=word.length()-1; i>=0; i--) {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null) return index;
            node = node.child[idx];
            index = node.index;
        }
        return index;
    }

    Trie root;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        root = new Trie(INF, -1);
        int minLength = INF, minIdx = -1;
        for(int i=0; i<wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
            if(wordsContainer[i].length() < minLength) {
                minLength = wordsContainer[i].length();
                minIdx = i;
            }
        }
        int[] ans = new int[wordsQuery.length];
        for(int i=0; i<wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
            ans[i] = ans[i] == -1 ? minIdx : ans[i];
        }
        return ans;
    }
}