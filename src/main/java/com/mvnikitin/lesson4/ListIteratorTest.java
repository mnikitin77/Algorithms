package com.mvnikitin.lesson4;

import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.insertFirst("Катя");
        linkedList.insertFirst("Вова");
        linkedList.insertFirst("Маша");
        linkedList.insertFirst("Петя");

        ListIterator<String> listIter = linkedList.listIterator();
        while (listIter.hasNext()) {
            System.out.print("[nextIndex: " + listIter.nextIndex() +
                    ", значение: " + listIter.next() + "] ");
        }
        System.out.println();

        while (listIter.hasPrevious()) {
            System.out.print("[previosIndex: " +listIter.previousIndex() +
                    ", значение: " + listIter.previous() + "] ");
        }
        System.out.println();

        if(listIter.hasNext()) {
            System.out.print("[nextIndex: " + listIter.nextIndex() +
                    ", значение: " + listIter.next() + "] ");
        }

        if(listIter.hasNext()) {
            System.out.print("[nextIndex: " + listIter.nextIndex() +
                    ", значение: " + listIter.next() + "] ");
        }

        if(listIter.hasPrevious()) {
            System.out.print("[previosIndex: " +listIter.previousIndex() +
                    ", значение: " + listIter.previous() + "] ");
        }
        System.out.println();

        listIter.add("Иннокентий");
        listIter.add("Ефросинья");
        while (listIter.hasPrevious()) {
           listIter.previous();
        }

        while (listIter.hasNext()) {
            System.out.print("[nextIndex: " + listIter.nextIndex() +
                    ", значение: " + listIter.next() + "] ");
        }
        System.out.println();

        while (listIter.hasPrevious()) {
            listIter.previous();
        }

        if(listIter.hasNext()) listIter.next();
        if(listIter.hasNext()) listIter.next();
        if(listIter.hasNext()) listIter.next();
        if(listIter.hasPrevious()) {
            System.out.print("[previosIndex: " +listIter.previousIndex() +
                    ", значение: " + listIter.previous() + "] ");
        }
        System.out.println();
    }
}
