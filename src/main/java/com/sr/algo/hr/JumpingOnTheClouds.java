package com.sr.algo.impl;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JumpingOnTheClouds {


        // Complete the jumpingOnClouds function below.
        static int jumpingOnClouds(int[] c) {
            int max = c.length;
            int jumpCounter=0;

            int i=0,j=0,k=0;
            while(i < max) {
                j=i+1;
                k=i+2;
                if(k < max) {
                    if( c[k] <= c[j] ) {
                        i=k;
                    } else {
                        i=j;
                    }
                    jumpCounter++;
                } else if(j==max) {
                    break;
                } else {
                    jumpCounter++;
                    i=j;
                }
            }
            return jumpCounter;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int result = jumpingOnClouds(c);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
}
