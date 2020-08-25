package com.sr.hr.interview.prep.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long lengthOfString = s.length();
        long leftOver =  n%lengthOfString;

        long subStringMatchRepeatedCount = countString(s)*(n/lengthOfString);
        long leftOverRepeatedCount = leftOver>0? countString(s.substring(0,(int)leftOver)):0;
        return subStringMatchRepeatedCount+leftOverRepeatedCount;
    }

    static long countString(String s) {
        return s.chars().filter(ch -> ch == 'a').count();
    }

    static long repeatedString() {
        return repeatedString("cfimaakj",554045874191L);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scanner.nextLine();

        //long n = scanner.nextLong();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        //long result = repeatedString(s, n);
        long result = repeatedString();
        System.out.println("result "+result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
