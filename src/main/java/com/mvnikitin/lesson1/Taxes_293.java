package com.mvnikitin.lesson1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Taxes_293 {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    private int firmsCount;
    private int[] profits;
    private int[] taxes;

    public static void main(String[] argv) throws IOException {
        new Taxes_293().run();
    }

    public void run() throws IOException{
        init();

        PrintWriter pw;
        pw = new PrintWriter(new File("output.txt"));
        pw.print(getMajorTaxpayer());
        pw.close();
    }

    private void init() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        if (sc.hasNextLine()) {
            firmsCount = Integer.parseInt(sc.nextLine());
        }

        profits = readIntArray(firmsCount, sc);
        taxes = readIntArray(firmsCount, sc);

        sc.close();
    }

    private int[] readIntArray(int size, Scanner sc) {
        int[] array = new int[size];

        if (sc.hasNextLine()) {
            String[] vals = sc.nextLine().split(" ");

            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(vals[i]);
            }
        }

        return array;
    }

    private int getMajorTaxpayer() {
        int res = 0;
        float maxTaxPayment = profits[0] * taxes[0] / 100.0f;

        for(int i = 1; i < profits.length; i++) {
            float taxPayment = profits[i] * taxes[i] / 100.0f;
            if (taxPayment > maxTaxPayment) {
                maxTaxPayment = taxPayment;
                res = i;
            }
        }

        // Нумеруем фирмы с 1.
        return res + 1;
    }
}
