package com.mvnikitin.lesson1;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Factorial {

    public static void main(String[] argv) throws IOException{
        new Factorial().run();
    }

    public void run() throws IOException{
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        sc.close();

        System.out.println(factorial(new BigInteger(value)));
    }

    private BigInteger factorial(BigInteger value) {
        if (value.equals(BigInteger.ONE) ||  value.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }
}
