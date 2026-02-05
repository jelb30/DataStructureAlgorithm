package Queue.common;

import java.util.*;

public final class QueueUtils {
    private QueueUtils() {}

    // Build queue in given order: first element = front.
    public static Deque<Integer> queue(int... values) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int v : values) q.offer(v);
        return q;
    }

    public static void print(Deque<?> q) {
        System.out.println(str(q));
    }

    public static String str(Deque<?> q) {
        return q.toString() + "  (front = first)";
    }

    public static <T> void offer(Deque<T> q, T x) {
        q.offer(x);
    }

    public static <T> T poll(Deque<T> q) {
        return q.poll();
    }

    public static <T> T peek(Deque<T> q) {
        return q.peek();
    }

    public static boolean isEmpty(Deque<?> q) {
        return q.isEmpty();
    }
}
