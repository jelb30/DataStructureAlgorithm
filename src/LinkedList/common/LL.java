package LinkedList.common;

import java.util.*;

public final class LL {
    private LL() {}

    // build(1,2,3) => 1 -> 2 -> 3
    public static ListNode build(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Print with basic cycle protection
    public static void print(ListNode head) {
        System.out.println(str(head));
    }

    public static String str(ListNode head) {
        if (head == null) return "empty";
        StringBuilder sb = new StringBuilder();
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (seen.contains(cur)) {
                sb.append(cur.val).append(" -> (cycle)");
                return sb.toString();
            }
            seen.add(cur);

            sb.append(cur.val);
            cur = cur.next;
            if (cur != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    // Optional: convert to array quickly
    public static int[] toArray(ListNode head) {
        List<Integer> out = new ArrayList<>();
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (seen.contains(cur)) break;
            seen.add(cur);
            out.add(cur.val);
            cur = cur.next;
        }

        int[] res = new int[out.size()];
        for (int i = 0; i < out.size(); i++) res[i] = out.get(i);
        return res;
    }

    // nodeAt(head, 0) = head
    public static ListNode nodeAt(ListNode head, int idx) {
        int i = 0;
        ListNode cur = head;
        while (cur != null && i < idx) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    // makeCycle(head, pos): tail.next -> nodeAt(pos). pos < 0 => no cycle
    public static ListNode makeCycle(ListNode head, int pos) {
        if (head == null || pos < 0) return head;
        ListNode entry = nodeAt(head, pos);
        if (entry == null) return head;

        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = entry;
        return head;
    }
}
