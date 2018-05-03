package com.sr.algo.impl.queen.attack;

import java.util.*;

public class QueensAttack {

    public enum DIR {
        LT, UP_LT, UP, UP_RT, RT, DN_RT, DN, DN_LT
    }

    static int queensAttack(int n, int k, int qr, int qc, int[][] obstacles) {
        int returnValue = 0;
        Set<int[]> obstHashes = new TreeSet<>(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt((int[] arr)-> arr[1]));

        if(k > 0) {
            for(int i = 0; i< obstacles.length;i++){
                obstHashes.add(obstacles[i]);
            }
        }

        for(DIR dir: DIR.values()) {
            returnValue+= getSquares(dir, n,  qr, qc, obstHashes);
        }
        return returnValue;
    }

    private static int getSquares(DIR dir, int n, int ir, int ic, Set<int[]> obstHashes) {
        int count = 0;
        int[] tmp = new int[2];
        while(true) {
            if(DIR.LT.equals(dir)){
                ic--;
            } else if(DIR.UP_LT.equals(dir)){
                ir++; ic--;
            } else if(DIR.UP.equals(dir)){
                ir++;
            } else if(DIR.UP_RT.equals(dir)){
                ir++; ic++;
            } else if(DIR.RT.equals(dir)){
                ic++;
            } else if(DIR.DN_RT.equals(dir)){
                ir--; ic++;
            } else if(DIR.DN.equals(dir)){
                ir--;
            } else if(DIR.DN_LT.equals(dir)){
                ir--; ic--;
            }

            if(ir > n || ir < 1 || ic > n || ic < 1) {
                break;
            }

            tmp[0] = ir;
            tmp[1] = ic;

            if(!obstHashes.isEmpty() && obstHashes.contains(tmp)){
                break;
            } else {
                count++;
            }
        }
        //System.out.println(dir+" => "+count);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
