package com.jedilab.java_oo;

public class LinkedList implements Collection {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(int value) {
        Node current = head;
        Node previous = null;
        while (current != null && current.value != value) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            if (current == tail) {
                tail = previous;
            }
            size--;
        }
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int[] toArray() {
        int[] result = new int[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.value;
            current = current.next;
            i++;
        }
        return result;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
