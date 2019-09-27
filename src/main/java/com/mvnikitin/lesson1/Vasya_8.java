package com.mvnikitin.lesson1;

import java.io.IOException;
import java.util.Scanner;

public class Vasya_8 {

    public static void main(String[] argv) throws IOException {
        new Vasya_8().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        sc.close();

        System.out.println((C == A * B) ? "YES" : "NO");
    }
}
