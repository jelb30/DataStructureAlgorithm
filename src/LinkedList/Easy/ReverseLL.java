package LinkedList.Easy;


// LEETCODE PROBLEM NUMBER 206.

import LinkedList.Medium.SortList;

public class ReverseLL {

    public static class ListNode{
        int val;
        public ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode getLast(ListNode head){
        while(head.next==null){
            return head;
        }
        return getLast(head.next);
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode last = getLast(head);
        reverse(head);
        return last;
    }

    public static ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }

        ListNode prevNode = reverse(head.next);
        prevNode.next = head;
        prevNode.next.next= null;

        return prevNode.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);

        //GETTING TAIL TO RETURN AS HEAD AFTER REVERAL.
        ListNode tail = getLast(l5);

        System.out.println("BEFORE REVERSEAL: ");
        display(l5);

        reverseList(l5); // REVERSAL LOGIC USING RECURSION.

        System.out.println("AFTER REVERSAL:");
        display(tail);
    }

    public static void display(ListNode head){
        if(head==null){
            System.out.print("null");
            return;
        }
        System.out.print(head.val+" -> ");
        display(head.next);
    }

}
