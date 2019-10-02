package com.mvnikitin.lesson3;

public class MyStack<T> {

    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private final int INCREASE_FACTOR = 2;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        if (isFull()) {
            increase(INCREASE_FACTOR);
        }
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }


    private T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void increase(int increaseFactor){
        T[] tempArr = (T[]) new Object[list.length * increaseFactor];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }
}
