package LinkedList.Medium;

import LinkedList.common.ListNode;

import java.util.List;

import static LinkedList.common.LL.*;

public class MaxTwinSum {

    public static int pairSum(ListNode head){
        ListNode reverse = reverseListIter(head);
        System.out.println("Before : "); print(head);
        System.out.println("After : "); print(reverse);
        ListNode curr = head;

        int max = curr.val + reverse.val;
        curr = curr.next;
        reverse = reverse.next;

        while(curr != null && curr.next != null){
            int currVal = curr.val + reverse.val;
            if( max < currVal){
                max = currVal;
            }
            curr = curr.next;
            reverse = reverse.next;
        }
        return max;
    }

    public static ListNode reverseListIter(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode curNew = dummy;
        ListNode cur = head;
        while (cur != null) {
            curNew.next = new ListNode(cur.val);
            curNew = curNew.next;
            cur = cur.next;
        }

        head = dummy.next;

        if(head == null || head.next ==null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while(current.next != null){

            ListNode tempNext = current.next;

            current.next = prev;
            prev = current;
            current = tempNext;

        }
        current.next = prev;

        return current;
    }



    public static void main(String[] args) {
        ListNode head = build(47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9);

        System.out.println("Current Max Sum: "+ pairSum(head));
    }
}
