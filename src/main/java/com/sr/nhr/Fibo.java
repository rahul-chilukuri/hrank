package com.sr.nhr;

import java.util.Arrays;

public class Fibo {
    static long numberOfCalls=0;
    public static void main(String[] args) {
        long it=0, rc=0, rcm=0;
        int n = 5;

        long[] memo = new long[n+1];
        memo[0] = 0;
        memo[1] = 1;

        //it = iterative(n);
        rc = recursive(n);
        //rcm = recursiveMemoization(n, memo);

        System.out.println("it  ==> "+it);
        System.out.println("rc  ==> "+rc);
        System.out.println("rcm ==> "+rcm);
        System.out.println("Total number of calls "+numberOfCalls);
        //System.out.println(recursive(n) == recursiveMemoization(n, memo));
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
        long fib=0;
        if(n <=0 ) {
            numberOfCalls++;
            fib = memo[0];
        } else if(n  == 1) {
            numberOfCalls++;
            fib = memo[1];
        } else {
            if(memo[n] == 0) {
                memo[n] = recursiveMemoization(n-1, memo)+recursiveMemoization(n-2, memo);
                //System.out.println(Arrays.toString(memo));
                numberOfCalls++;
            }
            fib = memo[n];
        }
        return fib;
    }
}
