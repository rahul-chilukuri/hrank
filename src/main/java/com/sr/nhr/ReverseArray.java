package com.sr.nhr;

import main.java.com.sr.utils.InputUtil;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        Integer[] arr = InputUtil.getIntArray();
        int n = arr.length;
        System.out.println("Before swap "+Arrays.toString(arr));
        for(int i=0;i < n/2; i++) {
            InputUtil.swapInts(arr, i, n-i-1);
        }
        System.out.println("After swap "+ Arrays.toString(arr));
    }
}
