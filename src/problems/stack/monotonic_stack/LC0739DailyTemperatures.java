package problems.stack.monotonic_stack;

import java.util.Stack;

public class LC0739DailyTemperatures {

    public static void main(String[] args) {

        int[] temps = new int[] {73,74,75,71,69,72,76,73};
        int[] results = dailyTemperatures(temps);
        for(int i: results) {
            System.out.println(i);
        }

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> stackIndexes = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while(!stackIndexes.isEmpty() && temperatures[i] > temperatures[stackIndexes.peek()]) {
                int index = stackIndexes.pop();
                results[index] = i - index;
            }
            stackIndexes.push(i);
        }

        return results;
    }
}
