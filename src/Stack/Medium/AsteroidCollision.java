package Stack.Medium;

import java.util.Stack;


public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {2,-1,1,-2};
        int[] result = asteroidCollision(asteroids);
        for(int i: result){
            System.out.println(i);
        }

    }

    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        boolean right = false;
        boolean left = false;
         int i = 0;

         while(i < asteroids.length){
             if(asteroids[i] > 0){
                 stack.push(asteroids[i]);
                 right = true;
                 left = false;
                 i++;
                 continue;
             }

             if(asteroids[i] < 0 && right == false ){
                 stack.push(asteroids[i]);
                 right = false;
                 left = true;
                 i++;
                 continue;
             }

             if(asteroids[i] < 0 && right == true && stack.isEmpty() == false){
                 int popped = stack.pop();
                 if(popped + asteroids[i] > 0){
                     stack.push(popped);
                     i++;
                     right = true;
                     left = false;
                     continue;
                 }
                 else if(popped + asteroids[i] < 0){
                     while(stack.isEmpty() == false) {
                         int tempPopped = stack.pop();
                         if (tempPopped < 0) {
                             stack.push(tempPopped);
                             stack.push(asteroids[i]);
                             right = false;
                             left = true;
                             i++;
                             break;
                         }
                         if (tempPopped + asteroids[i] > 0) {
                             stack.push(tempPopped);
                             right = true;
                             left = false;
                             i++;
                             break;
                         }
                         if (tempPopped + asteroids[i] == 0) {
                             if(stack.isEmpty() == false && stack.peek() > 0){
                                 right = true;
                                 left = false;
                             }else if(stack.isEmpty() == false && stack.peek() < 0){
                                 right = false;
                                 left = true;
                             }else{
                                 right = false;
                                 left = false;
                             }

                             i++;
                             break;
                         }
                     }
                     if(stack.isEmpty() && i < asteroids.length){
                         stack.push(asteroids[i]);
                         left = true;
                         right = false;
                         i++;
                     }
                 }
                 else if( popped + asteroids[i] == 0){
                     i++;
                     if(stack.isEmpty() == false && stack.peek() > 0){
                         right = true;
                         left = false;
                     }else if(stack.isEmpty() == false && stack.peek() < 0){
                         right = false;
                         left = true;
                     }else{
                         right = false;
                         left = false;
                     }
                 }
             }

         }

        int[] res = new int[stack.size()];
        for (int j = 0; j < stack.size(); j++) {
            res[j] = stack.get(j);
        }
        return res;
    }

}
