package com.mvnikitin.lesson2;

import java.util.Comparator;
import java.util.Random;

public class MyArrayTest {
    private static int ELEMENTS_COUNT = 100000;

    public static void main(String[] args) {
        MyArrayList<Integer> array1, array2, array3;

        array1 = new MyArrayList<>(ELEMENTS_COUNT);
        array2 = new MyArrayList<>(ELEMENTS_COUNT);
        array3 = new MyArrayList<>(ELEMENTS_COUNT);
        System.out.printf("Созданы три массива размером %d элементов.\n",
                ELEMENTS_COUNT);

        Random rnd = new Random();
        int value = 0;
        for(int i = 0; i < ELEMENTS_COUNT; i++) {
            value = rnd.nextInt(ELEMENTS_COUNT);
            array1.add(value);
            array2.add(value);
            array3.add(value);
        }
        System.out.println("Массивы заполнены одинаково случайными числами.");

        long timestamp = System.currentTimeMillis();
        array1.selectionSort();
        System.out.printf("Сортировка выбором: %d мс.\n",
                System.currentTimeMillis() - timestamp);
        System.out.println(array1.stringOfNFirstElements(20));

        timestamp = System.currentTimeMillis();
        array2.insertionSort();
        System.out.printf("Сортировка вставкой: %d мс.\n",
                System.currentTimeMillis() - timestamp);
        System.out.println(array2.stringOfNFirstElements(20));

        timestamp = System.currentTimeMillis();
        array3.bubbleSort();
        System.out.printf("Сортировка пузырьком: %d мс.\n",
                System.currentTimeMillis() - timestamp);
        System.out.println(array3.stringOfNFirstElements(20));

        timestamp = System.nanoTime();
        array3.add(123);
        System.out.printf("Добавление элемента в заполненный " +
                        "полностью массив: %d нс.\n",
                System.nanoTime() - timestamp);
    }
}

//    Созданы три массива размером 100000 элементов.
//    Массивы заполнены одинаково случайными числами.
//    Сортировка выбором: 15459 мс.
//    [0 0 2 3 5 7 7 7 8 8 8 8 10 18 18 20 21 22 24 25 ]
//    Сортировка вставкой: 11185 мс.
//    [0 0 2 3 5 7 7 7 8 8 8 8 10 18 18 20 21 22 24 25 ]
//    Сортировка пузырьком: 41603 мс.
//    [0 0 2 3 5 7 7 7 8 8 8 8 10 18 18 20 21 22 24 25 ]
//    Добавление элемента в заполненный полностью массив: 426300 нс.