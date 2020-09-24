package com.sr.hr.interview.prep.array;

import java.util.Scanner;

public class NewYearChaos {

    static void minimumBribes(int[] q, int n) {
        int bribeCount=0;
        for(int i=0, l1=1, l2=2, l3=3; i < n; i++) {
            if(q[i] == l1 ) {
                l1=l2;
                l2=l3++;
            } else if (q[i] == l2 ) {
                bribeCount++;
                l2=l3++;
            } else if(q[i] == l3) {
                bribeCount+=2;
                l3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribeCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q,n);
        }

        scanner.close();
    }
}
