package com.suganthan;

import java.util.Scanner;

public class ArraysOperations {

    final int MAX_ARRAY_SIZE = 10;
    int[] array = new int[MAX_ARRAY_SIZE];
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArraysOperations listUsingArrays = new ArraysOperations();
        int userInput = 0;
        do {
            System.out.println("\nEnter the option");
            System.out.println("1. Insert at a position");
            System.out.println("2. Add at the end");
            System.out.println("3. Delete from the end");
            System.out.println("4. Remove particular element");

            userInput = listUsingArrays.in.nextInt();
            switch (userInput) {
                case 1:
                    listUsingArrays.insert();
                    break;
                case 2:
                    listUsingArrays.add();
                    break;
                case 3:
                    listUsingArrays.delete();
                    break;
                case 4:
                    listUsingArrays.remove();
                    break;
            }
        } while(userInput != -1);

    }
    public void insert() {
        System.out.println("Enter the value to insert");
        int valueToInsert = in.nextInt();
        System.out.println("Enter the position to insert");
        int position = in.nextInt();
        array[position] = valueToInsert;
        displayArray();
    }

    public void add() {
        System.out.println("Enter the value to add");
        int valueToInsert = in.nextInt();
        for (int i=0; i < array.length; i++) {
            if(array[i] == 0) {
                array[i] = valueToInsert;
                break;
            }
        }
        displayArray();
    }

    public void delete() {
        System.out.println("Enter the value to delete");
        int valueToDelete = in.nextInt();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == valueToDelete) {
                array[i] = 0;
                break;
            }
        }
        displayArray();
    }

    public void remove() {
        System.out.println("Enter the from which position to remove");
        int position = in.nextInt();
        array[position] = 0;
        displayArray();
    }


    public void displayArray() {
        for (int i=0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}