package com.mvnikitin.lesson1;

import java.util.*;
import java.io.*;

public class CopyMachine{ //имя класса должно быть Main

    private Scanner sc;

    public static void main(String[] argv) throws IOException{
        new CopyMachine().run();
    }

    public void run() throws IOException{
        sc = new Scanner(System.in);
        int N=sc.nextInt(), x=sc.nextInt(), y=sc.nextInt();

        System.out.println(findMinimalTime(N, x, y));
        sc.close();
    }

    private int findMinimalTime(int n, int x, int y) {
        return  1 + (int)Math.floor(((double)n) * x * y / (x + y));
    }

//    PrintWriter pw;
//    Scanner sc;
//    public void run() throws IOException{
//        sc = new Scanner(new File("input.txt"));
//        int a=sc.nextInt(), b=sc.nextInt();
//        pw = new PrintWriter(new File("output.txt"));
//        pw.print(a+b);
//        pw.close();
//    }
}