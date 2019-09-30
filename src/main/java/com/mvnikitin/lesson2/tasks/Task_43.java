package com.mvnikitin.lesson2.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Task_43 {

    public static void main(String[] argv) throws IOException {
        new Task_43().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        char[] chars = s.toCharArray();

        int maxCount = 0;
        int currentCount = 0;

        for (char c: chars) {
            if (c == '0') {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }

        System.out.println(maxCount);
    }
}
