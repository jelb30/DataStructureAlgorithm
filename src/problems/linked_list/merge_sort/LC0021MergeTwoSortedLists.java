package problems.linked_list.merge_sort;

import common.list.SinglyLinkedList.*;

public class LC0021MergeTwoSortedLists {

    public Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node(-1);
        Node current = dummy;

        while(list1 != null && list2 != null){
            if(list1.getValue() <= list2.getValue()){
                current.setNext(list1);
                list1 = list1.getNext();
            }else{
                current.setNext(list2);
                list2 = list2.getNext();
            }
            current = current.getNext();
        }

        current.setNext((list1==null)?list2:list1);

        Node temp = dummy.getNext();
        while(temp !=null){
            System.out.print(temp.getValue()+" --> ");
            temp = temp.getNext();
        }
        System.out.println("TAIL");

        return dummy.getNext();

    }
}
