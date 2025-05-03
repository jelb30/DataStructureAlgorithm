package LinkedList;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL(){
        this.size=0;
    }

    public class Node{

        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
