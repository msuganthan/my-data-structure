package com.suganthan;

/**
 * Created by msuganthan on 13/7/17.
 */
public class ArraysSumCheckForPair_1 {
    public static void main(String[] args) {
        //Given an array A[] and a number x, check for a pair in A[] with sum as x
        //Given array {1, 4, 45, 6, 10, -8} and the sum to find is 16
        int[] arr = {1, 4, 45, 6, 10, -8};

        int sum = 16;
        int first = 0, last = arr.length-1;
        sort(arr);
        while (last>first) {
            int total = arr[first]+arr[last];
            if (total == sum) {
                System.out.println("Array has elements with sum 16");
                break;
            }

            if(total>sum)
                last--;
            if(total<sum)
                first++;
        }
    }

    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int key = arr[i];
            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
