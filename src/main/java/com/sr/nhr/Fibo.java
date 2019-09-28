package com.sr.nhr;

import com.sr.utils.InputUtil;

import java.util.Arrays;

public class Fibo {
    static long numberOfCalls=0;
    public static void main(String[] args) {
        long it=0, rc=0, rcm=0;
        int n = InputUtil.getRandomInt(20);
        System.out.println(" n  ==> "+n);

        long[] memo = new long[n+1];
        memo[0] = 0;
        memo[1] = 1;

        //it = iterative(n);
        //System.out.println("it  ==> "+it);

        //rc = recursive(n);
        //System.out.println("rc  ==> "+rc);

        //rcm = recursiveMemoization(n, memo);
        //System.out.println("rcm ==> "+rcm);

        printFibSeries(n, memo);
        //System.out.println("Total number of calls "+numberOfCalls);
    }

    private static long iterative(long n) {
        long fib = 0;
        if(n <= 0) {
            fib = 0;
        } else if(n == 1) {
            fib = 1;
        } else {
            long tn2 = 0;
            long tn1 = 1;
            for(long i=2; i <= n; i++) {
                fib = tn1 + tn2;
                tn2 = tn1;
                tn1 = fib;
            }
        }
        return fib;
    }

    private static long recursive(long n) {
        if(n <= 0) {
            numberOfCalls++;
            return 0;
        } else if(n == 1) {
            numberOfCalls++;
            return 1;
        } else {
            numberOfCalls++;
            return recursive(n-1)+recursive(n-2);
        }

    }

    private static long recursiveMemoization(int n, long[] memo) {
        long fib;
        if(n <=0 ) {
            numberOfCalls++;
            fib = memo[0];
        } else if(n  == 1) {
            numberOfCalls++;
            fib = memo[1];
        } else {
            if(memo[n] == 0) {
                memo[n] = recursiveMemoization(n-1, memo)+recursiveMemoization(n-2, memo);
                numberOfCalls++;
            }
            fib = memo[n];
        }
        return fib;
    }

    private static void printFibSeries(int n, long[] memo) {
        if(n > 1 ) {
            if(memo[n] == 0) {
                memo[n] = recursiveMemoization(n-1, memo)+recursiveMemoization(n-2, memo);
            }
        }
        long[] spliced = Arrays.copyOfRange(memo, 1, memo.length);
        System.out.println(Arrays.toString(spliced));
    }
}
