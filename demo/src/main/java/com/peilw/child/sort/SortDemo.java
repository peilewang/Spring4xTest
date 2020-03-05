package com.peilw.child.sort;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int a[] = {8, 7, 4, 9};
        //System.out.println(Arrays.toString(SortDemo.SelectionSort(a)));
        SortDemo.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    //选择排序
    public static int[] SelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    k = j;
                }
            }
            if (i < k) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    //二分查找
    public static int BinarySearch(int[] a, int b) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + high / 2;
            if (a[middle] < b) {
                low = middle + 1;
            } else if (a[middle] > b) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //快速排序
    public static void quickSort(int arr[], int start, int end) {
        int i, j, pivot;
        if (start > end) return;
        i = start;
        j = end;
        pivot = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[j] = t;
            }
        }
        //将基准位与i和j相等的位置交换
        arr[start] = arr[i];
        arr[i] = pivot;
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }
}
