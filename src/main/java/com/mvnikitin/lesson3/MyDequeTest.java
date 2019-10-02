package com.mvnikitin.lesson3;

public class MyDequeTest {

    public static void main(String[] args) {
        MyDeque<String> deq = new MyDeque<>();

        deq.insertLeft("Mexico");
        deq.insertLeft("Peru");
        deq.insertLeft("Guatemala");
        deq.insertLeft("Puerto Rico");
        deq.insertLeft("Panama");
        System.out.println(deq);
        System.out.println("Left = " + deq.peekLeft() + ", " +
                "Right = " + deq.peekRight());

        deq.insertRight("Cuba");
        deq.insertRight("Colombia");
        System.out.println(deq);

        System.out.println(deq.removeLeft() + " покинул очередь.");
        System.out.println(deq.removeLeft() + " покинул очередь.");
        System.out.println(deq.removeRight() + " покинул очередь.");
        System.out.println(deq);
        System.out.println("Left = " + deq.peekLeft() + ", " +
                "Right = " + deq.peekRight());

        deq.insertRight("Panama");
        deq.insertLeft("Colombia");
        System.out.println(deq);

        System.out.println("\nIs empty: " + deq.isEmpty() +
                ", is full: " + deq.isFull() +
                ", size: " + deq.size() + "\n");

        deq.insertLeft("Costa Rica");
        deq.insertLeft("Salvador");
        deq.insertLeft("Nicaragua");
        deq.insertLeft("Belize");
        deq.insertRight("Ecuador");
        deq.insertRight("Chile");
        deq.insertRight("Venezuela");
        System.out.println(deq);
        System.out.println("Left = " + deq.peekLeft() + ", " +
                "Right = " + deq.peekRight());

        System.out.println("\nIs empty: " + deq.isEmpty() +
                ", is full: " + deq.isFull() +
                ", size: " + deq.size());
    }
}
