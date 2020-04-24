package com.peilw.child.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortDemo {
    public static void main(String[] args) {
        int a[] = {8, 7, 4, 9};
        int b[] = SortDemo.reserver(a);
        System.out.println(Arrays.toString(b));
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
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }
        return a;
    }

    //插入排序
    public static int[] InsertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
        return arr;
    }

    //冒泡排序
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //二分查找
    public static int BinarySearch(int[] a, int b) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
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

    //颠倒数组元素的顺序
    public static int[] reserver(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    //判断一个数是不是素数
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

}
