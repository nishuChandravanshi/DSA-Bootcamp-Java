package com.kunal;


import java.util.HashMap;
import java.util.Map;

class LRUCache2 {
    private int capacity;
    private DLL head;
    private DLL tail;
    private Map<Integer, DLL> map = new HashMap<>();


    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (this.tail == null) {    //empty
            return value;
        }

        if (this.map.containsKey(key)) {
            DLL node = this.map.get(key);
            value = node.value;
            moveLast(node);
        }

        return value;

    }

    private void moveLast(DLL node) {
        if (node != null && tail != null) {
            DLL prev = node.prev;
            DLL next = node.next;

            //remove node
            prev.next = next;
            next.prev = prev;

            //add at last
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
            this.tail.next = null;
        }
    }

    public void put(int key, int value) {
        if (this.map.size() == capacity) {
            removeHead();
        }

        if (map.containsKey(key)) {
            DLL node = this.map.get(key);
            moveLast(node);
        } else {
            DLL node = new DLL(key, value);
            if (tail != null) {
                tail.next = node;
                node.prev = tail;
            }

            tail = node;

            if (head == null) {
                head = tail;
            }

            map.put(key, node);
        }

    }

    private void removeHead() {
        if (this.head == null) {
            return;
        }

        //if only one element. then remove it.
        if (this.head.next == null) {
            head = null;
            return;
        }

        DLL newHead = this.head.next;
        newHead.prev = null;
        newHead.next = this.head.next.next;
        this.head.next = null;

        this.head = newHead;
    }


    class DLL {
        int key;
        int value;
        DLL prev;
        DLL next;

        public DLL(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}