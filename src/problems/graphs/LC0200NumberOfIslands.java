package problems.graphs;
public class LC0200NumberOfIslands {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {

        int islands = 0;
        for (int r = 0; r <grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    islands++;
                    helper(grid, r, c);
                }
            }
        }
        return islands;
    }

    public static void helper(char[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        helper(grid, r, c-1);
        helper(grid, r-1, c);
        helper(grid, r, c+1);
        helper(grid, r+1, c);
    }

}
