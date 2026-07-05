class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        
        // scores[i][j] tracks the maximum score to reach cell (i, j)
        int[][] scores = new int[n][n];
        // ways[i][j] tracks the number of ways to reach cell (i, j) with that max score
        int[][] ways = new int[n][n];
        
        // Base case: 1 way to be at the starting point 'S'
        ways[n - 1][n - 1] = 1;
        
        // The 3 directions we can COME FROM: Right, Down, Bottom-Right
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}};
        
        // Traverse the board from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                
                // Skip obstacles and the starting cell itself
                if (c == 'X' || (i == n - 1 && j == n - 1)) continue;
                
                int maxScoreFromNeighbors = -1;
                
                // Check the three possible cells we could have traveled from
                for (int[] dir : directions) {
                    int prevRow = i + dir[0];
                    int prevCol = j + dir[1];
                    
                    // Check boundaries and ensure the previous cell is actually reachable
                    if (prevRow < n && prevCol < n && ways[prevRow][prevCol] > 0) {
                        
                        if (scores[prevRow][prevCol] > maxScoreFromNeighbors) {
                            // Found a STRICTLY larger score: update max score and reset ways
                            maxScoreFromNeighbors = scores[prevRow][prevCol];
                            ways[i][j] = ways[prevRow][prevCol];
                            
                        } else if (scores[prevRow][prevCol] == maxScoreFromNeighbors) {
                            // Found the SAME max score: add the number of ways together
                            ways[i][j] = (ways[i][j] + ways[prevRow][prevCol]) % MOD;
                        }
                    }
                }
                
                // If maxScoreFromNeighbors is still -1, this cell is completely unreachable
                if (maxScoreFromNeighbors == -1) continue;
                
                // Add the current cell's value to the score (Treat 'E' at 0,0 as 0 points)
                int currentCellScore = (c == 'E') ? 0 : (c - '0');
                scores[i][j] = maxScoreFromNeighbors + currentCellScore;
            }
        }
        
        // Return the max score and number of ways at the destination 'E'
        return new int[]{scores[0][0], ways[0][0]};
    }
}