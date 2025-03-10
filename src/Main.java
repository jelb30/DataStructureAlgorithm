import Recursion.*;

public class Main {

    public static void main(String[] args) {

        BinarySearch binarySearchImpl = new BinarySearch();
        binarySearchImpl.implementation();

        Factorial factorialImpl = new Factorial();
        factorialImpl.Implementation();

        InplaceReverseArray inplaceReverseArrayImpl = new InplaceReverseArray();
        inplaceReverseArrayImpl.Implementation();

        PowerOfProblem powerOfProblem = new PowerOfProblem();
        powerOfProblem.isPowerOfThree(45);

        StepsReduceToZero implementation = new StepsReduceToZero();
        int steps = implementation.numberOfSteps(8);
        System.out.println("Number of Steps it takes To Reduce "+14+" to Zero "+ steps);

    }
}