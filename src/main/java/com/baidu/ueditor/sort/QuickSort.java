package com.baidu.ueditor.sort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Author: guang
 * @CreateDate: 2019/4/19 21:18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 3, 8, 7, 9};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left+(int)(Math.random()*(right-left+1)), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0]-1);
            quickSort(arr, p[0]+1, right);
        }
    }
    public static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l , --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1, more};
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
