package com.mvnikitin.lesson4;

import java.util.Iterator;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        System.out.println("Is empty? " + queue.isEmpty());

        queue.offer("Катя");
        queue.offer("Вова");
        queue.offer("Маша");
        queue.offer("Петя");
        System.out.println(queue.toString());

        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());

        System.out.println("Offer: Валя");
        queue.offer("Валя");

        Iterator<String> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println();
        System.out.println("Size: " + queue.size());
    }
}
