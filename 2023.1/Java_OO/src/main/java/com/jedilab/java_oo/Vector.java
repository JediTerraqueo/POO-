package com.jedilab.java_oo;

public class Vector implements Collection {
    private int[] array;
    private int size;
    private int capacity;

    public Vector() {
        this.array = new int[10];
        this.size = 0;
        this.capacity = 10;
    }

    public void add(int value) {
        if (size == capacity) {
            increaseCapacity();
        }

        array[size] = value;
        size++;
    }

    public void remove(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private void increaseCapacity() {
        int[] newArray = new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity *= 2;
    }
}
