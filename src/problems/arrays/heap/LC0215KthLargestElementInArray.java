package problems.arrays.heap;

import java.util.PriorityQueue;

public class LC0215KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        //USING MIN-HEAP.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums) {
            minHeap.add(i);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

}
