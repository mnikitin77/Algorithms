package com.mvnikitin.lesson3;

import java.util.Scanner;

public class MyStackTest {

    public static void main(String[] args) {
        System.out.println("Введите строку, которую необходимо перевернуть\n" +
                "или exit, чтобы завершить программу.\n");

        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if (str.equals("exit")) {
                break;
            } else {
                System.out.println(turnString(str));
            }
        }

        sc.close();
    }

    private static String turnString(String src) {
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}

//    Введите строку, которую необходимо перевернуть
//    или exit, чтобы завершить программу.
//
//    Однажды, в студеную зимнюю пору я из лесу вышел; был сильный мороз.
//    .зором йыньлис лыб ;лешыв усел зи я уроп ююнмиз юунедутс в ,ыджандО
//    .зором йыньлис лыб ;лешыв усел зи я уроп ююнмиз юунедутс в ,ыджандО
//    Однажды, в студеную зимнюю пору я из лесу вышел; был сильный мороз.
//    exit