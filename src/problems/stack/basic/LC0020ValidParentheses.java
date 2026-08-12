package problems.stack.basic;

import java.util.Stack;

public class LC0020ValidParentheses {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if(c == ')' && top == '(') {
                    stack.pop();
                } else if(c == ']' && top == '[') {
                    stack.pop();

                } else if(c == '}' && top == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
