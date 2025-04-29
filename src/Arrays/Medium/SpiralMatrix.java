package Arrays.Medium;


import java.util.ArrayList;
import java.util.List;

// LEETCODE PROBLEM NUMBER 54.
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        spiralOrder(matrix);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        int startingRow = 0;
        int startingCol = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int endingCol = cols-1;
        int endingRow = rows-1;

        int count = 0;
        int totalInt = rows*cols;

        while(count<totalInt){

            for (int index = startingRow; index <= endingCol && count<totalInt; index++) {
                resultList.add(matrix[startingRow][index]);
                count++;
            }
            startingRow++;

            for (int index = startingRow; index <= endingRow && count<totalInt; index++) {
                resultList.add(matrix[index][endingCol]);
                count++;
            }
            endingCol--;

            for (int index = endingCol; index >= startingCol && count<totalInt; index--) {
                resultList.add(matrix[endingRow][index]);
                count++;
            }
            endingRow--;

            for (int index = endingRow; index >= startingRow && count<totalInt; index--) {
                resultList.add(matrix[index][startingCol]);
                count++;
            }
            startingCol++;

        }

        return resultList;
    }
}
