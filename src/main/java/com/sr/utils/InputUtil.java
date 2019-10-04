package com.sr.utils;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);
    public static Integer[] getIntArray() {
        int n= (int) (20*Math.random());
        if(n < 3) {
            n+=n*2+n%3;
        }
        Integer[] c = new Integer[n];
        for (int i = 0; i < n; i++) {
            int cItem = (int) (10*Math.random()+n%2);
            c[i] = cItem;
        }
        scanner.close();
        return c;
    }

    public static int getRandomInt(int n) {
        return (int) Math.ceil(Math.random()*n);
    }

    public static void swapInts(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
