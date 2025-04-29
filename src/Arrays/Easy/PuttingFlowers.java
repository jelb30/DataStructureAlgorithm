package Arrays.Easy;

//LEETCODE QUESTION 605.
public class PuttingFlowers {

    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==0 && n>0){
                boolean lefttCheck = (i==0 || flowerbed[i-1]==0);
                boolean rightCheck = (i==flowerbed.length-1 || flowerbed[i+1]==0);

                if(lefttCheck && rightCheck){
                    flowerbed[i] = 1; // PUTTING FLOWER IN IT.
                    n--;
                }
            }
        }
        return n==0;
    }

}
