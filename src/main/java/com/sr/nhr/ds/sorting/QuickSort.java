package com.sr.nhr.ds.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = InputUtil.getIntArray();
        //Integer[] arr = new Integer[]{8,7,5,4,3,2,1};
        //Integer[] arr = new Integer[]{1,2,3,4,5,7,8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(Integer[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = arr[getPIndex(left, right)];
        int p = partition(arr, left, right, pivot);
        quickSort(arr, left, p-1);
        quickSort(arr, p, right);
    }

    public static int partition(Integer[] arr, int left, int right, int pivot) {
        while(left < right) {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }

            if(left<=right) {
                InputUtil.swapInts(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static int getPIndex(int left, int right) {
        return (left+right)/2;
        //return left;
        //return right;
    }
}
