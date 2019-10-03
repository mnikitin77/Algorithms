package com.mvnikitin.lesson3;

import java.util.Arrays;

public class MyDeque<T> {

    private T[] data;
    private int size;
    private int head;
    private int tail;

    private final static int DEFAULT_CAPACITY = 10;
    private final int INCREASE_FACTOR = 2;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Invalid capacity: " + capacity);
        }
        data = (T[]) new Object[capacity];

        size = 0;
        head = data.length - 1;
        tail = 0;
    }

    public MyDeque() {
        this(DEFAULT_CAPACITY);
    }

    // вставка с левой стороны <<<<
    public void insertLeft(T item) {
        if (isFull()) {
            increase(INCREASE_FACTOR);
        }
        size++;
        tail = nextBackward(tail);
        data[tail] = item;
    }

    // вставка с правой стороны >>>>
    public void insertRight(T item) {
        if (isFull()) {
            increase(INCREASE_FACTOR);
        }
        size++;
        head = nextForward(head);
        data[head] = item;
    }

    public T removeLeft() {
        T res = peekLeft();
        size--;
        data[tail] = null;
        tail = nextForward(tail);
        return res;
    }

    public T removeRight() {
        T res = peekRight();
        size--;
        data[head] = null;
        head = nextBackward(head);
        return res;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Container is empty");
        }
        return data[tail];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Container is empty");
        }
        return data[head];
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public boolean isFull () {
        return size == data.length;
    }

    public int size () {
        return size;
    }

    @Override
    public String toString() {
        return "MyDeque{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    private int nextBackward (int index) {
        return (index == 0) ? data.length - 1 : index - 1;
    }

    private int nextForward (int index) {
        return (index + 1) % data.length;
    }

    private void increase(int increaseFactor){
        T[] tempArr = (T[]) new Object[data.length * increaseFactor];

        if (head > tail) {
            System.arraycopy(data, tail, tempArr, 0, size);
            tail = 0;
            head = size - 1;
        } else {
            System.arraycopy(data, 0, tempArr, 0, head + 1);
            System.arraycopy(data, tail, tempArr,
                    tempArr.length - size + head + 1, size - head - 1);
            tail = tempArr.length - size + head + 1;
        }

        data = tempArr;
    }
}
