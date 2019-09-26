package com.mvnikitin.lesson1;

import java.util.*;
import java.io.*;

public class Copy {
    public static void main(String[] args) {
        System.out.println(findMinimalTime(4, 1, 1));
        System.out.println(findMinimalTime(5, 1, 2));
    }

    public static int findMinimalTime(int n, int x, int y) {
        return  1 + (int)Math.floor(((double)n) * x * y / (x + y));
    }
}
