package LinkedList.Medium;

import LinkedList.Easy.ReverseLL;
import LinkedList.LL;

public class ReverseLL2 {
    public static class ListNode{
        int val;
        public ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode getValue(int index, ListNode head, int size){
        if(index==0 || index>size){
            return null;
        }
        ListNode tempNode = head;
        for (int i = 1; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left==right){
            return head;
        }
        ListNode tempNode = head;
        int size = 0;
        while(tempNode!= null){
            size++;
            tempNode = tempNode.next;
        }

        // TO ATTACH NODES TO REVERSED LIST!
        ListNode first = getValue(left-1, head, size);
        ListNode last = getValue(right+1, head, size);


        ListNode prev = last;
        ListNode current = ( first == null ) ? head : first.next;

        //BASIC REVERSE LIST OPERATION!
        int count = 0;
        while(count!=(right-left+1)){

            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
            count++;

        }

        if(first != null){
            first.next = prev;
            return head;
        }
        return prev;
    }

    public static void display(ListNode head){
        if(head==null){
            System.out.print("null");
            System.out.println();
            return;
        }
        System.out.print(head.val+" -> ");
        display(head.next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);

        display(l5);

        display(reverseBetween(l5, 2, 4));
    }

}
