package Arrays.Medium;


//LEETCODE PROBLEM NUMBER 48.

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1},
                {1, 0}
        };

        int[][] target = {
                {1, 0},
                {0, 1}
        };

        System.out.println(findRotation(matrix, target));

    }

    public static void rotate(int[][] matrix) {

        // FIRST WE TRANSPOSE THE 2D MATRIX


        for (int i = 0; i < matrix.length-1; i++) {

            for (int j = i; j < matrix.length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // THEN REVERS THE MATRIX.

        for (int i = 0; i < matrix.length; i++) {
            recursionSwap(0, matrix.length-1, matrix[i]);
        }


    }

    public static void recursionSwap(int start, int end, int[] arr){
        if(start>=end){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        recursionSwap(start+1, end-1, arr);

    }

    public static boolean findRotation(int[][] mat, int[][] target) {

        int count = 0;
        while(count<4){
            for (int i = 0; i < mat.length-1; i++) {

                for (int j = i; j < mat.length; j++) {

                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            for (int i = 0; i < mat.length; i++) {
                recursionSwap(0, mat.length-1, mat[i]);
            }

            boolean isMatch = false;
            int matchCount = 0;

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if(mat[i][j] != target[i][j]){
                        break;
                    }
                    matchCount++;
                }
            }

            if(matchCount == Math.pow(mat.length, 2)) return true;

            count++;
        }

        return false;

    }
}
