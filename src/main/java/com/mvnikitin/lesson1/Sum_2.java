package com.mvnikitin.lesson1;

import java.io.IOException;
import java.util.Scanner;

public class Sum_2 {

    public static void main(String[] argv) throws IOException {
        new Sum_2().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(calcSum(n));
    }

    private int calcSum(int value) {
        int res = (1 + Math.abs(value)) * value / 2;
        return (value > 0) ? res : res + 1;
    }
}
