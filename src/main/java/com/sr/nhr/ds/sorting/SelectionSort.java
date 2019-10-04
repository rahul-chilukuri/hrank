package com.sr.nhr.ds.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = InputUtil.getIntArray();
        //Integer[] arr = new Integer[]{8,7,5,4,3,2,1};
        //Integer[] arr = new Integer[]{1,2,3,4,5,7,8};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(Integer[] arr){
        for(int i = 0 ; i < arr.length-1;i++) {
            int min = i;
            for(int j=i+1; j < arr.length;j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(min !=i) {
                InputUtil.swapInts(arr, i, min);
            }
        }

    }
}
