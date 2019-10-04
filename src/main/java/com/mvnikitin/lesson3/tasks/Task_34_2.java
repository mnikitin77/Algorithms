package com.mvnikitin.lesson3.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_34_2 {

    private static final String INPUT = "input.txt";
    private int messageLength;
    private int numberLength;
    private String message;

    public Task_34_2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String data[] = sc.nextLine().split(" ", 2);
        messageLength = Integer.parseInt(data[0]);
        numberLength = Integer.parseInt(data[1]);

        message = sc.nextLine();
        sc.close();
    }

    public static void main(String[] argv) throws IOException {
        new Task_34_2().run();
    }

    public void run() throws IOException {

        boolean found = false;
        Set<String> set = new HashSet<>();

        if (0 <= messageLength && messageLength <= 100000 &&
                1 <= numberLength && numberLength <= 5) {
            for (int i = 0; i <= messageLength - numberLength; i++) {
                if (!set.add(message.substring(i, i + numberLength))) {
                    found = true;
                    break;
                }
            }
        }

        System.out.println(found == true ? "YES" : "NO");
    }
}

