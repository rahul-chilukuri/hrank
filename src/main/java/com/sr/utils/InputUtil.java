package com.sr.utils;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);
    public static Integer[] getIntArray() {
        System.out.println("Enter array ");
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int n = cItems.length;
        Integer[] c = new Integer[n];
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
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
