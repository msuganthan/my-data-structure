package com.suganthan.Arrays;

/**
 * Created by msuganthan on 12/7/17.
 */
public class SortedArray {
    public static int findElementBinarySearch(int[] arr, int low, int high, int key) {
        if(high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(key == arr[mid])
            return mid;
        if (key > arr[mid])
            return findElementBinarySearch(arr, (mid+1), high, key);
        return findElementBinarySearch(arr, low, (mid-1), key);
    }

    public static int insertSortedArray(int arr[], int n, int capacity, int key) {
        if(n >= capacity)
            return n;
        int i;
        for (i=n-1; (arr[i]>key && i >= 0); i--) {
            arr[i+1] = arr[i];
        }
        arr[i+1] = key;
        return n+1;
    }

    public static int deleteSortedArray(int arr[], int n, int key) {
        int pos = findElementBinarySearch(arr, 0, n-1, key);
        if (pos == -1) {
            System.out.println("No elements found ");
            return n;
        }
        for (int i = pos; i < n-1; i++) {
            arr[i] = arr[i-1];
        }
        return n-1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10};
        int n,key;
        n = arr.length;
        key =10;
        System.out.println("Search Index : "+ findElementBinarySearch(arr, 0, n, key));

        int arr1[] = new int[20];
        arr1[0] = 12;
        arr1[1] = 16;
        arr1[2] = 20;
        arr1[3] = 40;
        arr1[4] = 50;
        arr1[5] = 70;
        int capacity = arr1.length;
        n = 6;
        key = 26;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i]+ " ");
        }
        int insertIndex = insertSortedArray(arr1, n, capacity, key);
        System.out.println("\n after insertion");
        for (int i = 0; i < insertIndex; i++) {
            System.out.print(arr1[i]+ " ");
        }

        key = 40;
        n = deleteSortedArray(arr1, insertIndex, key);
        System.out.print("\n\nArray after deletion:\n");
        for (int i=0; i<n; i++)
            System.out.print(arr1[i] + " ");
    }
}
