package com.mvnikitin.lesson2.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Task_92 {

    public static void main(String[] argv) throws IOException {
        new Task_92().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(n/6 + " " + (2 * n) / 3 + " " + n/6);
    }
}
