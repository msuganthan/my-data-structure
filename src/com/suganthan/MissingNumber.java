package com.suganthan;

/**
 * Created by msuganthan on 15/7/17.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2;
        for (int i = 0; i < n; i++) {
            total -= arr[i];
        }
        System.out.println(total);

    }
}
