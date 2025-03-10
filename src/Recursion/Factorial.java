package Recursion;

public class Factorial {

    public void Implementation(){
        int n = 19;
        int factorialVal = factorialByRecursion(n);
        System.out.println(factorialVal);
    }

    public int factorialByRecursion(int n){
        if(n ==0){
            return 1;
        }
        return n*factorialByRecursion(n-1);
    }

}
