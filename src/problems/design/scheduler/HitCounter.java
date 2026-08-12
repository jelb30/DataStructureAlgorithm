package problems.design.scheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> q;
    private final int WINDOW = 300;

    public HitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    // CLEANS THE EXPIRED ONES, WHEN THIS FUNCTION IS CALLED.
    public int getHits(int timestamp) {
        while(!q.isEmpty() && (timestamp - q.peek() >= WINDOW)) {
            q.poll();
        }
        return q.size();
    }
}
