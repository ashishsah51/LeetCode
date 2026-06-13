class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        // Map<Integer, Character> map = new HashMap<>();
        // char ch = 'a';
        // for(int wt : weights) {
        //     map.put(wt, ch);
        //     ch++;
        // }
        for(String word : words) {
            int cnt = 0;
            for(char c : word.toCharArray()) {
                cnt += weights[c-'a'];
            }
            cnt = 26 - (cnt % 26) - 1;
            // System.out.println(cnt);
            sb.append((char)(cnt+'a'));
        }
        return sb.toString();
    }
}