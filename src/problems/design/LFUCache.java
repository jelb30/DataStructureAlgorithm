package problems.design;
import java.util.HashMap;

public class LFUCache {

    public static class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    public static class DoublyLinkedList {
        int size;
        Node head, tail;

        public DoublyLinkedList() {
            size = 0;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node node) {
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
            size++;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        //REMOVIN LEAST RECENTLY USED NODE.
        public Node removeLast() {
            if(size==0) return null;
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    private HashMap<Integer, Node> nodes;
    private HashMap<Integer,DoublyLinkedList> freqToList;
    private final int CAPACITY;
    private int minFreq;


    public LFUCache(int capacity) {
        minFreq = 0;
        nodes = new HashMap<>();
        CAPACITY = capacity;
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if(!nodes.containsKey(key)) return -1;
        Node node = nodes.get(key);
        touch(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) return;
        if(nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.value = value;
            touch(node);
            return;
        }

        if (nodes.size() >= CAPACITY) {
            DoublyLinkedList minList = freqToList.get(minFreq);
            Node evicted = minList.removeLast();     // LFU + LRU tiebreak
            nodes.remove(evicted.key);
        }

        // Insert the new key at frequency 1.
        Node node = new Node(key, value);
        nodes.put(key, node);
        freqToList.computeIfAbsent(1, f -> new DoublyLinkedList()).addToHead(node);
        minFreq = 1;
    }

    // A node was used: move it from its current freq-shelf up to freq+1.
    private void touch(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqToList.get(oldFreq);
        oldList.removeNode(node);

        // If we just emptied the minFreq shelf, the new min is one higher.
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Promote the node to the next frequency shelf, at the front (most recent).
        node.freq++;
        freqToList.computeIfAbsent(node.freq, f -> new DoublyLinkedList())
                .addToHead(node);
    }
}
