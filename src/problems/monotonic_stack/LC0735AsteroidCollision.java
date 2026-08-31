package problems.monotonic_stack;
import java.util.Stack;


public class LC0735AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {2,-1,1,-2};
        int[] result = asteroidCollision(asteroids);
        for(int i: result){
            System.out.println(i);
        }

    }

    public static int[] asteroidCollision(int[] asteroids){

        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            boolean survived = true;

            while(asteroid < 0 && survived && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if(top < -asteroid) {
                    stack.pop();
                } else if( top == -asteroid) {
                    stack.pop();
                    survived = false;
                } else if ( top > -asteroid) {
                    survived = false;
                }
            }
            if(survived) {
                stack.push(asteroid);
            }
        }

        int[] results = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            results[i] = stack.pop();
        }


        return results;
    }

}
