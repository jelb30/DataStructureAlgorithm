package Arrays.Easy;

// LEET CODE QUESTION 286!
public class MissingNumber {

    public static void main(String[] args) {

    }


    public int missingNumber(int[] nums) {

        int[] hashArray = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            hashArray[currentNumber] = 1;
        }

        for (int i = 0; i < hashArray.length; i++) {
            if(hashArray[i]==0){
                return i;
            }
        }

        return -1;
    }

}
