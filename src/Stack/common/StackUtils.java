package Stack.common;

import java.util.*;

public final class StackUtils {
    private StackUtils() {}

    // Build a stack where the LAST value becomes the TOP (natural push order).
    public static Deque<Integer> stack(int... values) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int v : values) st.push(v); // last pushed is top
        return st;
    }

    public static void print(Deque<?> st) {
        System.out.println(str(st));
    }

    public static String str(Deque<?> st) {
        return st.toString() + "  (top = first)";
    }

    public static <T> T pop(Deque<T> st) {
        return st.pop();
    }

    public static <T> void push(Deque<T> st, T x) {
        st.push(x);
    }

    public static <T> T peek(Deque<T> st) {
        return st.peek();
    }

    public static boolean isEmpty(Deque<?> st) {
        return st.isEmpty();
    }
}
