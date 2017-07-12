package com.suganthan.Arrays;

/**
 * Created by msuganthan on 12/7/17.
 */
public class UnSortedArray {
    public static void main(String[] args) {

        int arr[] = {12, 34, 10, 6, 40};
        int arrayLength = arr.length;

        int searchIndex = findElement(arr, arrayLength, 40);
        System.out.println("searchIndex : "+searchIndex);

        int arr1[] = new int[20];
        arr1[0] = 12;
        arr1[1] = 16;
        arr1[2] = 20;
        arr1[3] = 40;
        arr1[4] = 50;
        arr1[5] = 70;
        int capacity = arr1.length;
        int insertIndex = 6;
        int insertElement = 98;
        insertIndex = insertElement(arr1, capacity, insertIndex, insertElement);
        for (int i = 0; i < insertIndex; i++) {
            System.out.println(arr1[i]);
        }

        int deleteElement = 40;
        int deleteIndex = deleteElement(arr1, capacity, deleteElement);
        for (int i = 0; i < deleteIndex; i++) {
            System.out.println(arr1[i]);
        }
    }

    //search
    /* In unsorted array search can be performed using linear traversal from the
     * first element to the last element
     * It is costly operation as the array grows
     */
    public static int findElement(int arr[], int arrayLength, int searchElement) {
        for (int i = 0; i < arrayLength; i++) {
            if(arr[i] == searchElement) {
                return i;
            }
        }
        return -1;
    }
    //insert
    /* In unsorted array we don't need to worry about the position in which we are inserting the
     * element
     */
    public static int insertElement(int arr[], int maxCapacity, int index, int key) {
        if(index >= maxCapacity)
            return index;

        arr[index] = key;

        return index + 1;
    }
    //delete
    /*
     * Delete is a costly operation far unsorted array is consider
     * 1. Find the element using linear search
     * 2. Shift operation, if the element is found
     */
    public static int deleteElement(int arr[], int capacity, int key) {
        int elementIndex = findElement(arr, capacity, key);
        if (elementIndex == -1) {
            System.out.println("No element found");
            return -1;
        }

        for(int i = elementIndex; i < capacity-1; i++) {
            arr[i] = arr[i+1];
        }
        return capacity-1;
    }
}
