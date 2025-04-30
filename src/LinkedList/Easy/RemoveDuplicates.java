package LinkedList.Easy;

import LinkedList.LL.*;

// LEETCODE QUESTION 83.
public class RemoveDuplicates {

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
