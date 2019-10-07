package com.mvnikitin.lesson4;

import java.util.Iterator;
import java.util.Queue;

public class MyQueue<T> implements Iterable<T>{

    private MyLinkedList<T> linkedList;

    public MyQueue(MyLinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }

    public MyQueue() {
        this(new MyLinkedList<>());
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean offer(T t) {
        linkedList.insertFirst(t);
        return true;
    }

    public T poll() {
        return linkedList.removeLast();
    }

    public T peek() {
        return linkedList.getLast();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
