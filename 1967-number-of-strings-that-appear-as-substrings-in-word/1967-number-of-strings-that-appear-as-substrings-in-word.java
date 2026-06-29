class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // Set<String> set = patterns.toList().stream().collect(Collectors.toSet());
        int cnt  = 0;
        for(String pattern : patterns) {
            if(word.contains(pattern)) cnt++;
        }
        return cnt;
    }
}