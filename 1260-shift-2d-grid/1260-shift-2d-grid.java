class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k-->0) {
            grid = getGrid(grid);
        }
        return Arrays.stream(grid)
                .map(row -> Arrays.stream(row)
                                  .boxed() // Converts int to Integer
                                  .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
    int[][] getGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tm = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n-1; j++) {
                tm[i][j+1] = grid[i][j];
            }
        }

        for(int i=0; i<m-1; i++) tm[i+1][0] = grid[i][n-1];
        tm[0][0] = grid[m-1][n-1];
        return tm;
    }
}