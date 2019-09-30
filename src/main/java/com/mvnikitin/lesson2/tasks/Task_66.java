package com.mvnikitin.lesson2.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Task_66 {

    public static void main(String[] argv) throws IOException {
        new Task_66().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c',
                'v', 'b', 'n', 'm'};

        for (int i = 0; i < letters.length; i++) {
            if (s.charAt(0) == letters[i]) {
                System.out.println(letters[(i + 1) % letters.length]);
                break;
            }
        }
    }
}

