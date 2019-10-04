package com.mvnikitin.lesson3.tasks;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task_34 {

    private static final String INPUT = "input.txt";
    private int messageLength;
    private int numberLength;
    private String message;

    public Task_34() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String data[] = sc.nextLine().split(" ", 2);
        messageLength = Integer.parseInt(data[0]);
        numberLength = Integer.parseInt(data[1]);

        message = sc.nextLine();
        sc.close();
    }

    public static void main(String[] argv) throws IOException {
        new Task_34().run();
    }

    public void run() throws IOException {
        boolean found = false;

        if (0 <= messageLength && messageLength <= 100000 &&
            1 <= numberLength && numberLength <= 5) {

            for (int i = 0; i < messageLength - numberLength; i++) {
                for (int j = i + 1; j < messageLength - numberLength + 1; j++) {
                    //System.out.println(message.substring(j, j + numberLength));
                    if (message.substring(i, i + numberLength).equals(
                            message.substring(j, j + numberLength))) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }

        System.out.println(found == true ? "YES" : "NO");
    }
}
