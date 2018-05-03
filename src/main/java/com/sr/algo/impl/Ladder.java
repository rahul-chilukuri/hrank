package com.sr.algo.impl;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Ladder {

    /*
     * Complete the climbingLeaderboard function below.
     */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] rankingArray = new int[alice.length];
        int max = scores[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ldrBrdScores = new ArrayList<>();
        for(int i=0, j=0;j<scores.length;j++) {
            if(!map.containsKey(scores[j])) {
                map.put(scores[j], ++i);
                ldrBrdScores.add(scores[j]);
            }
        }
        
        int ldrScoreIndex = ldrBrdScores.size()-1;
        int ldrScore;
        for(int j=0;j< alice.length;j++){
            int aliceScore = alice[j];

            if(aliceScore >=max) {
                rankingArray[j] = 1;
                continue;
            }

            while(ldrScoreIndex>-1) {
                ldrScore = ldrBrdScores.get(ldrScoreIndex);
                if(aliceScore == ldrScore) {
                    rankingArray[j] = map.get(ldrScore);
                    ldrScoreIndex--;
                    break;
                } else if(aliceScore < ldrScore) {
                    rankingArray[j] = map.get(ldrScore)+1;
                    break;
                } else {
                    ldrScoreIndex--;
                }
            }
        }
        
        return rankingArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = Integer.parseInt(scanner.nextLine().trim());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
            scores[scoresItr] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine().trim());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
            alice[aliceItr] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
