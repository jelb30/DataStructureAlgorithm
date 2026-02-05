package Arrays.Easy;

// LEETCODE PROBLEM NUMBER 832.
public class FlippingImage {

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        flipAndInvertImage(image);

    }

    public static int[][] flipAndInvertImage(int[][] image) {

        int subArrayLen = image[0].length;

        //INVERTING THE ARRAY FIRST. 1 TO 0 AND 0 TO 1.
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < subArrayLen; j++) {
                if(image[i][j]==1){
                    image[i][j] =0;
                    continue;
                }
                image[i][j] =1;
            }
        }

        // REVERSE THE SUB ARRAYS.
        for (int i = 0; i < image.length; i++) {

            for (int j = 0; j < subArrayLen/2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][subArrayLen-1-j];
                image[i][subArrayLen-1-j] = temp;
            }
        }

        return image;
    }




}
