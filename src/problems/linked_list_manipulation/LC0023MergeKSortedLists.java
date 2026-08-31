package problems.linked_list_manipulation;
import common.list.ListNode;

import java.util.PriorityQueue;

public class LC0023MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head: lists) {
            if(head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            current.next = next;
            current = current.next;

            if(next.next != null) {
                minHeap.add(next.next);
            }
        }

        return dummy.next;
     }
}
