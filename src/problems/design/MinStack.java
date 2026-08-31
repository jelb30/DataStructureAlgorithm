package problems.design;
import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        // WE ARE GONNA STORE THE MIN AT EVERY LEVEL OF THE MINSTACK, NOT STORING THE VALUES, JUTST THE MINS!
        if(minStack.isEmpty()) minStack.push(value);
        else minStack.push(Math.min(value, minStack.peek()));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }

}
