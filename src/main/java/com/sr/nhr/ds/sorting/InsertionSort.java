package com.sr.nhr.ds.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arr = InputUtil.getIntArray();
        //Integer[] arr = new Integer[]{8,7,5,4,3,2,1};
        //Integer[] arr = new Integer[]{1,2,3,4,5,7,8};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(Integer[] arr){
        for(int i=0; i < arr.length-1;i++) {
            for(int j=i+1; j < arr.length; j++) {
                if( (i < j && arr[j] < arr[i]) || ( i > j && arr[j] > arr[i])) {
                    InputUtil.swapInts(arr, i , j);
                }
            }
        }
    }

    public static void sort(Integer[] arr){
        // 5 1 8 3 9 6
        for(int i=0; i< arr.length;i++) {
            int temp = arr[i];
            int j = i;
            while(j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] =temp;
        }
    }
}
