package com.baidu.ueditor.sort;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Author: guang
 * @CreateDate: 2019/4/19 22:03
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 3, 8, 7, 9};
        //quickSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        for (int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0 ,--size);
        while (size > 0) {
            heapity(arr, 0, size);
            swap(arr, 0, --size);
        }

    }
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapity(int[] arr, int index, int size) {
        int left = index*2 + 1;
        while (left < size) {
            int larget = left+1 < size && arr[left] < arr[left+1]
                    ? left+1 :left;
            larget = arr[index] < arr[larget] ? larget : index;
            if (larget == index) {
                return ;
            }
            swap(arr, larget, index);
            left = index*2 +1;
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
