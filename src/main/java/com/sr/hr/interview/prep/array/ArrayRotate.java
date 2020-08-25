package com.sr.hr.interview.prep.array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotate {

    static void rotate(int[] b, int d) {
        b = new int[]{1,2,3,4,5};
        d = 1;
        int arrLength = b.length;
        int rotations = d%arrLength;
        System.out.println("Original -> "+ Arrays.toString(b));
        if(rotations == 0) {
            System.out.println("No change -> "+ Arrays.toString(b));
        } else {
            System.out.println("Number of rotations "+rotations);
            System.out.println("Left -> "+ Arrays.toString(leftRotation(b, rotations)));
            System.out.println("Right -> "+ Arrays.toString(rightRotation(b, rotations)));
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