package LinkedList.Easy;

import java.util.List;

public class CheckPalindrome {

    public static class ListNode{
        int val;
        public ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseListIter(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while(current != null){

            ListNode tempNext = current.next;

            current.next = prev;
            prev = current;
            current = tempNext;

        }
        return prev;
    }

    public static boolean isPalindorme(ListNode head){

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode secondHalfReverse = reverseListIter(slowPointer);
        ListNode firstHalf = head;

        while(secondHalfReverse != null){
            if( firstHalf.val != secondHalfReverse.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalfReverse = secondHalfReverse.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(1, l3);

        isPalindorme(l4);
    }
}
