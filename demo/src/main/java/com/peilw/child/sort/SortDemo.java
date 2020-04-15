package com.peilw.child.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortDemo {
    public static void main(String[] args) {
        int a[] = {8, 7, 4, 9};
        //System.out.println(Arrays.toString(SortDemo.SelectionSort(a)));
        SortDemo.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(">>>>>>>>>>>>>>>>>>");
        int[] arr = {1, 1, 5, 7, 9, 11, 17, 27, 35, 66, 77, 99, 101};
        int num = 2;
        int[] arr1 = getSumToANum1(arr, num);
        System.out.println(arr1[0] + "," + arr1[1]);
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
                arr[i] = t;
            }
        }
        //将基准位与i和j相等的位置交换
        arr[start] = arr[i];
        arr[i] = pivot;
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }

    //冒泡排序
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    //有序的整形数组，给定一个数，在数组中找出两个数的和等于这个数，并打印出来
    public static int[] getSumToANum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] getSumToANum(int arr[], int start, int end, int num) {
        int[] arr1 = new int[2];
        while (start <= end) {
            if (num == (arr[start] + arr[end])) {
                arr1[0] = start;
                arr1[1] = end;
                break;
            } else if (num > (arr[start] + arr[end])) start++;
            else end--;
        }
        return arr1;
    }

}
