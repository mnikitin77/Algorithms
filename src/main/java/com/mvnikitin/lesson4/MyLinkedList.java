package com.mvnikitin.lesson4;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private class Iter implements Iterator<T> {

        Node<T> current = new Node(null,first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.getValue();
        }
    }

    private class ListIter implements ListIterator<T> {

        private class Cursor {
            private Node<T> previous;
            private Node<T> next;

            public Cursor() {
                this.previous = new Node(null, first);
                next = previous.getNext();
            }


            public Node<T> getPrevious() {
                return previous;
            }

            public Node<T> getNext() {
                return next;
            }

            public T moveForward() {
                previous = next;
                next = next.getNext();

                return previous.getValue();
            }

            public T moveBack() {
                next = previous;
                previous = previous.getPrevious();

                return next.getValue();
            }
        }

        private final static int INITIAL_INDEX = -1;

        private Cursor cursor;
        private int index;

        public ListIter() {
            cursor = new Cursor();
            index = INITIAL_INDEX;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            hasNext = cursor.getNext() != null;
            if (!hasNext) index = size();
            return hasNext;
        }

        @Override
        public T next() {
            index++;
            return cursor.moveForward();
        }

        @Override
        public boolean hasPrevious() {
            boolean hasPrevious = false;
            hasPrevious = cursor.getPrevious() != null;
            if (!hasPrevious) index = INITIAL_INDEX;
            return hasPrevious;
        }

        @Override
        public T previous() {
            index--;
            return cursor.moveBack();
        }

        @Override
        public int nextIndex() {
            if(hasNext()) {
                return index + 1;
            }

            return size();
        }

        @Override
        public int previousIndex() {
            if(hasPrevious()) {
                return index - 1;
            }

            return INITIAL_INDEX;
        }

        //TODO
        @Override
        public void remove() {
        }

        //TODO
        @Override
        public void set(T t) {
        }

        @Override
        public void add(T t) {
            insert(t, nextIndex());
            index++;
        }
    }

    class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }


    public void insertFirst(T t) {
        Node newNode = new Node(t);
        newNode.setNext(first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrevious(newNode);
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        return (T) oldFirst.getValue();
    }

    public void insertLast(T t) {
        Node newNode = new Node(t);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
        } else {
            first = null;
        }
        size--;
        last = last.getPrevious();
        return (T) oldLast.getValue();
    }

    public void insert(T t, int index) {
        if (index <= 0) {
            insertFirst(t);
            return;
        }
        if (index > size) {
            index = size;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(t);
        newNode.setNext(current.next);
        newNode.setPrevious(current);
        current.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        size++;
    }

    public boolean remove(T t) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(t)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null &&
                !current.getValue().equals(t)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }
        current.getNext().setPrevious(current.previous);
        current.getPrevious().setNext(current.next);
        size--;
        return true;
    }

    public boolean remove(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            return false;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        if (current == null) {
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }
        current.getNext().setPrevious(current.previous);
        current.getPrevious().setNext(current.next);
        size--;
        return true;
    }

    public boolean contains(T t) {
        return indexOf(t) > -1;
    }

    public int indexOf(T t) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(t)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current.next != null) {
            sb.append(current.getValue() + ", ");
            current = current.next;
        }
        sb.append(current.getValue());
        return sb.toString();
    }
}
