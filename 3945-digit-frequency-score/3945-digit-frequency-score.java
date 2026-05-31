class Solution {
    public int digitFrequencyScore(int n) {
        int score = 0;

        // Process each digit of the number
        while (n > 0) {
            int digit = n % 10;  // Extract last digit
            score += digit;      // Add digit to score
            n /= 10;             // Remove last digit
        }

        return score;
    }
}