package com.mvnikitin.lesson2.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Task_68 {

    public static void main(String[] argv) throws IOException {
        new Task_68().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        sc.close();

        if((s.equals("Home") && x % 2 == 0) ||
                (s.equals("School") && x % 2 == 1)) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}

