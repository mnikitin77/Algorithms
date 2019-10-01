package com.mvnikitin.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int currentCapacity;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Comparable[capacity];
        currentCapacity = capacity;
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        if(size == currentCapacity) {
            increaseSize();
        }
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        if(size == currentCapacity) {
            increaseSize();
        }
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public boolean remove(T item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public T get(int index) {
        return list[index];
    }

    public void set(int index, T item) {
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public boolean find(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + " ");
        }
        return s.toString();
    }

    public String stringOfNFirstElements(int num) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < num; i++) {
            sb.append(list[i] + " ");
        }
        return sb.append("]").toString();
    }


    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private void increaseSize() {
        currentCapacity *= 2;
        T[] tempList = (T[]) new Comparable[currentCapacity];
        System.arraycopy(list, 0, tempList, 0, list.length);
        list = tempList;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];

            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        bubbleSort(Comparator.naturalOrder());
    }

    public void bubbleSort(Comparator comparator) {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
//                if (less(list[j + 1], list[j])) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
//                System.out.println(i);
                break;
            }
        }
    }

}
