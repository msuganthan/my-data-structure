package com.suganthan;

/**
 * Created by msuganthan on 15/7/17.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4}; //3 3 4 2 4 4 2 4 4 ===> 4
        sort(arr);
        int toMajority = arr.length/2;
        int key = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(key == arr[i]) {
                count++;
                if (count>toMajority) {
                    System.out.println(key +"   is the majority element");;
                }
            } else {
                count = 1;
            }
            key = arr[i];
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
