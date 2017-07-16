package com.suganthan;

/**
 * Created by msuganthan on 15/7/17.
 */
public class Kadane {
    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE, max_ending = 0;
        for (int i = 0; i < size - 1; i++) {
            max_ending = max_ending + arr[i];
            if (max_ending < 0)
                max_ending = 0;
            if(max_so_far < max_ending)
                max_so_far = max_ending;
        }
        return max_so_far;
    }
}
