class Solution {
    public int passwordStrength(String password) {
        Set<Character> set = new HashSet<>();
        int score = 0;
        for(char c : password.toCharArray()) {
            if(set.contains(c)) continue;
            set.add(c);

            if(Character.isDigit(c)) {
                score += 3;
            } else if(Character.isLowerCase(c)) {
                score++;
            } else if(Character.isUpperCase(c)) {
                score += 2;
            } else {
                score += 5;
            }
        }
        return score;
    }
}