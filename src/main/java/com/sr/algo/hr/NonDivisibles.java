package com.sr.algo.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NonDivisibles {

    /*
     * Complete the nonDivisibleSubset function below.
     */
    static int nonDivisibleSubset(int k, int[] S) {
        int n = S.length;
        int[] rems = new int[k];
        Arrays.fill(rems, 0);
        for(int i=0; i< n; i++) {
            rems[S[i]%k]++;
        }
        
        if(k%2 == 0) {
            rems[k/2] = Math.min(rems[k/2], 1);
        }
        
        int maxLength = Math.min(rems[0], 1);
        for(int i = 1; i<= k/2;i++) {
            maxLength+=Math.max(rems[i], rems[k-i]);
        }
        
        return maxLength;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");

        for (int SItr = 0; SItr < n; SItr++) {
            int SItem = Integer.parseInt(SItems[SItr].trim());
            S[SItr] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
