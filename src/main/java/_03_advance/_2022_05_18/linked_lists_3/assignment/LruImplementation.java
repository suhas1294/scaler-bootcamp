package _03_advance._2022_05_18.linked_lists_3.assignment;

import java.util.HashMap;

// Note : LRU Implementation in assignment is in reverse direction
public class LruImplementation {

    class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList previousNode;
        DoublyLinkedList nextNode;

        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
            this.previousNode = null;
            this.nextNode = null;
        }
    }

    int capacity;
    HashMap<Integer, DoublyLinkedList> cache;
    public DoublyLinkedList headNode = null;
    public DoublyLinkedList tailNode = null;

    public LruImplementation(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedList currentNode = cache.get(key);
            // If the key is the last node then we don't have to remove it and insert it again.
            // We will delete the node and insert it at the last for other nodes
            if (currentNode.nextNode != null) {
                removeNode(currentNode);
                insertAtLast(currentNode);
            }
            return currentNode.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            DoublyLinkedList updateNode = cache.get(key);
            updateNode.value = value;
            // If the node is not the last then remove the node and its entry in hashmap
            // and then again insert the node with new value.
            if (updateNode.nextNode != null) {
                removeNode(updateNode);
                insertAtLast(updateNode);
            }
        } else { // new data
            DoublyLinkedList newNode = new DoublyLinkedList(key, value);
            if (cache.size() == capacity) { // no space
                DoublyLinkedList deleteNode = removeHeadNode();
                cache.remove(deleteNode.key);
                cache.put(key, newNode);
                insertAtLast(newNode);
            } else { // there is space
                cache.put(key, newNode);
                insertAtLast(newNode);
            }
        }
    }

    public void removeNode(DoublyLinkedList currentNode) {
        // Condition for checking if its a single node
        if (currentNode.nextNode == null && currentNode.previousNode == null) {
            headNode = null;
            tailNode = null;
            return;
        }

        // Condition to check if the node is last node and update the tailNode
        if (currentNode == tailNode) {
            tailNode = currentNode.previousNode;
            return;
        }

        // If the head is pointing to the currentNode point it to the nextNode
        if (headNode == currentNode) headNode = headNode.nextNode;

        DoublyLinkedList currentPreviousNode = currentNode.previousNode;
        DoublyLinkedList currentNextNode = currentNode.nextNode;
        currentNextNode.previousNode = currentPreviousNode;
        if (currentPreviousNode != null) currentPreviousNode.nextNode = currentNextNode;
    }

    public void insertAtLast(DoublyLinkedList currentNode) {
        if (headNode == null) {
            headNode = currentNode;
            tailNode = currentNode;
            return;
        }
        tailNode.nextNode = currentNode;
        currentNode.previousNode = tailNode;
        tailNode = currentNode;
    }

    public DoublyLinkedList removeHeadNode() {
        DoublyLinkedList deleteNode = headNode;
        if (headNode.nextNode == null && headNode.previousNode == null) {
            headNode = null;
            tailNode = null;
        } else {
            headNode = headNode.nextNode;
        }
        return deleteNode;
    }

    public static void main(String[] args) {
        LruImplementation lru = new LruImplementation(2);
        lru.set(1, 10);
        lru.set(5, 12);
        lru.get(5);  // 12
        lru.get(1);  // 10
        lru.get(10);  // -1
        lru.set(6, 14);
        lru.get(5); // -1
    }
}

// LRU : Least resource used
/*
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.

The LRUCache will be initialized with an integer corresponding to its capacity.
Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set
operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :
Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
 */