package LinkedList.Medium;

import LinkedList.LL;

// BASED ON TWO POINTERS.
// FAST AND SLOW POINTER METOD.
// LEETCODE PROBLEM 142.

public class FindCycleStart {

    public LL.Node findingCycleStart(LL.Node head){
        if(head == null || head.next == null) return null;

        LL.Node slowPointer = head;
        LL.Node fastePinter = head;

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

        LL.Node start = head;
        while(start != slowPointer){
            start = start.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
