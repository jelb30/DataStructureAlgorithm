package Recursion;

public class StepsReduceToZero {

    public int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        return countingFunction(num, 0);
    }

    public static int countingFunction(int num, int steps){

        if(num%2==0){
            return countingFunction(num/2, steps+1);
        }
        if(num==1){
            return steps+1;
        }

        return countingFunction((num-1)/2, steps+2);
    }

}
