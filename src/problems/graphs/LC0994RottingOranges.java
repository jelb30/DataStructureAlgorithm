package problems.graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC0994RottingOranges {

    public static void main(String[] args) {

        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        int[][] test2 = {{2,1,1}, {0,1,1}, {1,0,1}};

        System.out.println(orangesRotting(grid));
        //System.out.println(orangesRotting(test2));

    }

    //BFS For the rotting oranges with rotted oranges in Queue
    public static int orangesRotting(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        int totalMins = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!q.isEmpty()){
            int levelSize = q.size();
            boolean isRotten = false;

            for(int i = 0; i < levelSize; i++){
                int[] cur = q.poll();
                for (int[] dir: dirs) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        isRotten = true;
                        freshOranges--;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            if(isRotten)  totalMins++;
        }

        return freshOranges > 0 ? -1: totalMins;
    }
}
