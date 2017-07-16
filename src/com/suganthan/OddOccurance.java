package com.suganthan;

/**
 * Created by msuganthan on 15/7/17.
 */
public class OddOccurance {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 2, 3, 4, 5, 4, 5};
        int n = arr.length;
        System.out.println(getOddOccurrence(arr, n));
    }

    static int getOddOccurrence(int ar[], int ar_size) {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++) {
            res = res ^ ar[i];

        }
        return res;
    }

}
