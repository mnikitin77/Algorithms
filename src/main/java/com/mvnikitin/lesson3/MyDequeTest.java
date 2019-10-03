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
        System.out.println("Is empty: " + deq.isEmpty() +
                ", is full: " + deq.isFull() +
                ", size: " + deq.size() + "\n");

        deq.insertLeft("Costa Rica");
        deq.insertLeft("Salvador");
        deq.insertLeft("Nicaragua");
        deq.insertLeft("Belize");
        System.out.println(deq);
        System.out.println("Left = " + deq.peekLeft() + ", " +
                "Right = " + deq.peekRight());
        System.out.println("Is empty: " + deq.isEmpty() +
                ", is full: " + deq.isFull() +
                ", size: " + deq.size() + "\n");


        deq.insertRight("Ecuador");
        deq.insertRight("Chile");
        deq.insertRight("Venezuela");
        System.out.println(deq);
        System.out.println("Left = " + deq.peekLeft() + ", " +
                "Right = " + deq.peekRight());
        System.out.println("Is empty: " + deq.isEmpty() +
                ", is full: " + deq.isFull() +
                ", size: " + deq.size());
    }
}

//    MyDeque{data=[null, null, null, null, null, Panama, Puerto Rico, Guatemala, Peru, Mexico]}
//    Left = Panama, Right = Mexico
//    MyDeque{data=[Cuba, Colombia, null, null, null, Panama, Puerto Rico, Guatemala, Peru, Mexico]}
//    Panama покинул очередь.
//    Puerto Rico покинул очередь.
//    Colombia покинул очередь.
//    MyDeque{data=[Cuba, null, null, null, null, null, null, Guatemala, Peru, Mexico]}
//    Left = Guatemala, Right = Cuba
//    MyDeque{data=[Cuba, Panama, null, null, null, null, Colombia, Guatemala, Peru, Mexico]}
//    Is empty: false, is full: false, size: 6
//
//    MyDeque{data=[Cuba, Panama, Belize, Nicaragua, Salvador, Costa Rica, Colombia, Guatemala, Peru, Mexico]}
//    Left = Belize, Right = Panama
//    Is empty: false, is full: true, size: 10
//
//    MyDeque{data=[Cuba, Panama, Ecuador, Chile, Venezuela, null, null, null, null, null, null, null, Belize, Nicaragua, Salvador, Costa Rica, Colombia, Guatemala, Peru, Mexico]}
//    Left = Belize, Right = Venezuela
//    Is empty: false, is full: false, size: 13