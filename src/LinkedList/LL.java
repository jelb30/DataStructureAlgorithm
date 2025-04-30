package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void add(int value){
        Node node = new Node(value);
        if(this.head==null){
            this.head = node;
            this.tail = node;
            System.out.println("SUCCESSFULLY ADDED AT HEAD: "+value);
            size++;
            return;
        }

        Node tempNode = head;

        while(tempNode.getNext()!=null){
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(node);
        this.tail = node;

        size++;

        System.out.println("SUCCESSFULLY ADDED: "+value);
    }

    public void addAtFirst(int value){
        Node node = new Node(value);
        Node temp = head;
        this.head = node;
        node.next = temp;
    }

    public Node getHead() {
        return head;
    }

    public void insertAtIndex(int index, int value){
        if(index > size+1){
            throw new RuntimeException("WRONG INDEX!");
        }
        if(index==0){
            addAtFirst(value);
            size++;
            return;
        }
        insertRec(index, value, head);
    }

    //INSERT USING RECURSION.
    private void insertRec(int index, int value, Node currNode){
        if(index==1) {
            Node tempNode = currNode.next;
            Node newNode = new Node(value);
            currNode.next = newNode;
            newNode.next = tempNode;
            size++;
            return;
        }
        insertRec(index-1, value, currNode.next);
    }

    public void deleteAtIndex(int index){

        Node tempNode = head;
        int size = 0;
        while(tempNode !=null){
            tempNode = tempNode.getNext();
            size++;
        }

        Node currentNode = head;

        Node previousNode = null;
        for (int i = 0; i < size/2; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(currentNode.getNext());
    }

    public void display(){
        Node tempNode = this.head;
        while(tempNode !=null){
            System.out.print(tempNode.getValue()+" --> ");
            tempNode = tempNode.getNext();
        }
        System.out.println("TAIL");
    }

    public int getValue(int index){
        if(index>size-1){
            throw new RuntimeException("INVALID INDEX!");
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        return tempNode.getValue();
    }

    public Node getNode(int index){
        if(index>size-1){
            throw new RuntimeException("INVALID INDEX!");
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        return tempNode;
    }

    public int getSize() {
        return size;
    }

    public static class Node {

        public  int value;
        public  Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }
    }

    public class ListNode{
        int val;
        public ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
