package problems.graphs;
public class LC0695MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!seen[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, seen, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, boolean[][] seen, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        seen[r][c] = true;
        return (1 + dfs(grid, seen, r+1, c) + dfs(grid, seen, r-1, c) + dfs(grid, seen, r, c+1) + dfs(grid, seen, r, c-1));
    }
}
