package problems.heap_priority_queue;
import java.util.PriorityQueue;

public class LC0973KClosestPointsToOrigin {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] results = new int[k][];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>
                ((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] cords: points) {
            maxHeap.offer(cords);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int i = k-1; i >= 0; i--) {
            results[i] = maxHeap.poll();
        }

        return results;
    }
}
