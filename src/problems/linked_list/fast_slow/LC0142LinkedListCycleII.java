package problems.linked_list.fast_slow;

import common.list.SinglyLinkedList;

// BASED ON TWO POINTERS.
// FAST AND SLOW POINTER METOD.
// LEETCODE PROBLEM 142.

public class LC0142LinkedListCycleII {

    public SinglyLinkedList.Node findingCycleStart(SinglyLinkedList.Node head){
        if(head == null || head.next == null) return null;

        SinglyLinkedList.Node slowPointer = head;
        SinglyLinkedList.Node fastePinter = head;

        while(fastePinter != null && fastePinter.next!=null){
            slowPointer = slowPointer.next;
            fastePinter = fastePinter.next.next;

            if(slowPointer == fastePinter){
                break;
            }
        }

        if(slowPointer!=fastePinter){
            return null;
        }

        SinglyLinkedList.Node start = head;
        while(start != slowPointer){
            start = start.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
