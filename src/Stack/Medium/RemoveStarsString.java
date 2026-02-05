package Stack.Medium;

import Stack.common.StackUtils;

import java.util.Stack;

public class RemoveStarsString {

    public static void main(String[] args) {
        String test = new String("leet**cod*edex*");
        System.out.println(removeStars(test));
    }

    public static String removeStars(String str) {

        Character[] arr = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*'){
                stack.pop();
            }
            else{
                stack.push(arr[i]);
            }
        }

        String returnedString = "";

        while(stack.isEmpty() == false){
            Character c = stack.pop();
            returnedString = c + returnedString;
        }
        return returnedString;

    }

}
