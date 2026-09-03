package problems.graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC1091ShortestPathInBinaryMatrix {

    public static void main(String[] args) {

        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
        int shortestPath = shortestPathBinaryMatrix(grid);
        System.out.println(shortestPath);
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int size = grid.length;
        if(grid.length==0 || grid[0][0] != 0 || grid[size-1][size-1] != 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid.length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        grid[0][0] = 1;

        int[][] dirs = {{-1, -1},{-1, 1}, {1, 1}, {1, -1}, {0,1}, {1,0}, {0, -1}, {-1, 0}} ;
        while(!q.isEmpty()) {

            for (int i = 0; i < q.size(); i++) {
                int[] cordintions = q.poll();
                int r = cordintions[0];
                int c = cordintions[1];
                int pathSize = cordintions[2];

                if(r == rows-1 && c == rows-1) {
                    return pathSize;
                }
                for(int[] dir: dirs) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0 ){
                        q.offer(new int[]{newRow, newCol, pathSize+1});
                        grid[newRow][newCol] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
