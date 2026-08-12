package problems.design.cache;

import problems.tree.bst.LC0108ConvertSortedArrayToBinarySearchTree;
import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode prev;
    }

    //USING THIS COMBO TO HELP EACH DataStructure'S WEAKNESS!
    private HashMap<Integer, ListNode> hashMap;
    private final ListNode head;
    private final ListNode tail;
    private final int CAPACITY;
    private int currentSize;


    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
        CAPACITY = capacity;
        currentSize = 0;
    }

    public int get(int key) {
        if(!hashMap.containsKey(key)) {
            return -1;
        }
        ListNode node = hashMap.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        ListNode node = new ListNode();
        node.key = key;
        node.value = value;
        addToFront(node);
        hashMap.put(key, node);
        currentSize++;

        if(currentSize > CAPACITY) {
            ListNode prevTail = tail.prev;
            hashMap.remove(prevTail.key);
            removeNode(prevTail);
            currentSize--;
        }
    }

    public void addToFront(ListNode node) {
        ListNode nextToHead = head.next;
        head.next = node;
        node.next = nextToHead;
        node.prev = head;
        nextToHead.prev = node;
    }

    public void moveToFront(ListNode node) {
        removeNode(node);
        addToFront(node);
    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
