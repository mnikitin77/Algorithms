package com.mvnikitin.lesson2.tasks;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Task_46 {

    public static void main(String[] argv) throws IOException {
        new Task_46().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(new BigDecimal("2.7182818284590452353602875").
                setScale(n, RoundingMode.HALF_EVEN));
    }
}
