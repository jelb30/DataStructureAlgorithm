package Recursion;

public class PowerOfProblem {
    public boolean isPowerOfThree(int n){
        if(n<=0){
            return false;
        }

        boolean validation =  Validating(n);
        System.out.println("The number "+n+" is power of three : "+validation);
        return validation;
    }

    public static boolean Validating(int n) {

        if(n==1){
            return true;
        }

        if(n%3!=0){
            return false;
        }

        return Validating(n/3);
    }
}
