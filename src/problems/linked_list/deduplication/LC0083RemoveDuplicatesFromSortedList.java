package problems.linked_list.deduplication;

import common.list.SinglyLinkedList.*;

// LEETCODE QUESTION 83.
public class LC0083RemoveDuplicatesFromSortedList {

    public Node deleteDuplicates(Node head) {

        int previousVal = head.getValue();
        Node tempNode = head;

        while(tempNode.getNext() != null){

            if(tempNode.getNext().getValue() != previousVal){
                previousVal = tempNode.getNext().getValue();
                tempNode = tempNode.getNext();
                continue;
            }
            Node temp = tempNode.getNext().getNext();
            tempNode.setNext(temp);
        }
        return head;
    }
}
