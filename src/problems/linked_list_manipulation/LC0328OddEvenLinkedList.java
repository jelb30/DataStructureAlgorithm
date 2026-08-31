package problems.linked_list_manipulation;
import common.list.SinglyLinkedList;
import common.list.ListNode;
import static common.list.LinkedListUtils.*;

public class LC0328OddEvenLinkedList {

    public static ListNode oddEvenlist(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = build(1,2,3,4,5,6);
        System.out.println("Before: "); print(head);

        ListNode ans = oddEvenlist(head);
        System.out.println("After: "); print(ans);

    }

}
