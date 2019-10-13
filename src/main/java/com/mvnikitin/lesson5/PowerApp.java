package com.mvnikitin.lesson5;

public class PowerApp {
    public static void main(String[] args) {
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("5^4 = " + power(5, 4));
        System.out.println("3^5 = " + power(3, 5));
        System.out.println("9^2 = " + power(9, 2));
    }

    public static long power(long number, int power) {
        return (power <= 0) ? 1 : power(number, power -1) * number;
    }
}

//    2^10 = 1024
//    5^4 = 625
//    3^5 = 243
//    9^2 = 81