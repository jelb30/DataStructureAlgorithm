package LinkedList.Easy;

import LinkedList.LL.*;

import javax.swing.plaf.IconUIResource;


// FAST AND SLOW POINTER METOD.
// WHENEVER DEALING WITH THE CYCLE IN DSA, TRY THE FAST AND SLOW POINTER METOD.
public class CycleDetection {

    public class ListNode{
        public int val;
        public ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // FAST AND SLOW POINTER METHOD O(N) COMPLEXITY.
    public boolean hasCycle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer!=null){
            slowPointer = slowPointer.next;
            if (fastPointer.next!=null){
                fastPointer = fastPointer.next.next;
                if(slowPointer==fastPointer){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }

    public int lengthOfCycle(Node head){
        Node slowPointer = head;
        Node fastePinter = head;

        int cycleSize = 0;
        while(fastePinter != null && fastePinter.next!=null){
            slowPointer = slowPointer.next;
            fastePinter = fastePinter.next.next;

            if(slowPointer == fastePinter){
                slowPointer = slowPointer.next;
                cycleSize++;
                while(slowPointer != fastePinter){
                    slowPointer = slowPointer.next;
                    cycleSize++;
                }
                break;
            }
        }
        return cycleSize;
    }
}
