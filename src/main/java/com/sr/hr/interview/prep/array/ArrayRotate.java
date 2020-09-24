package com.sr.hr.interview.prep.array;

import com.sr.utils.InputUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotate {

    static void rotate(int[] b, int d) {
        b = new int[]{1,2,3,4,5};
        d = 4;
        int arrLength = b.length;
        int rotations = d%arrLength;
        System.out.println("Original -> "+ Arrays.toString(b));
        if(rotations == 0) {
            System.out.println("No change -> "+ Arrays.toString(b));
        } else {
            System.out.println("Number of rotations "+rotations);
            leftRotationInPlace(b, rotations);
            System.out.println("Left -> "+ Arrays.toString(b));
            //System.out.println("Right -> "+ Arrays.toString(leftRotation(b, rotations)));
            //System.out.println("Right -> "+ Arrays.toString(rightRotation(b, rotations)));
        }
    }

    static void leftRotationInPlace(int[] a, int d) {
        int n = a.length;
        int k = d%n;
        reverse(a, 0, n);
        reverse(a, 0, n-k);
        reverse(a, n-k, n);
    }

    private static void reverse(int[] a, int j, int k){
        int l = j+k;
        for(int i=j; i<l/2; i++){
            InputUtil.swapInts(a, i, l-1-i);
        }
    }

    static int[] leftRotation(int[] before, int d) {
        int arrLength = before.length;
        int[] after = new int[arrLength];
        for(int i = 0; i < arrLength; i++) {
            int afterIndex = i - d;
            if( afterIndex < 0) {
                after[arrLength+afterIndex] = before[i];
            } else {
                after[afterIndex]  = before[i];
            }
        }
        return after;
    }

    static int[] rightRotation(int[] before, int d) {
        int arrLength = before.length;
        int[] after = new int[arrLength];
        for(int i = 0; i < arrLength; i++) {
            int afterIndex = i - d;
            if( afterIndex < 0) {
                after[i] = before[arrLength+afterIndex];
            } else {
                after[i] = before[afterIndex];
            }
        }
        return after;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        rotate(null, 0);
    }
}