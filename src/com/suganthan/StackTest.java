package com.suganthan;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by msuganthan on 2/7/17.
 */
public class StackTest {
    final int MAX_SIZE = 10;
    int stack[] = new int[MAX_SIZE];
    static int index = 0;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        int userInput = 0;
        int valueToPush = 0;
        do {
            System.out.println("\nEnter the option");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            userInput = stackTest.scanner.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Enter the value to insert");
                    valueToPush = stackTest.scanner.nextInt();
                    stackTest.push(valueToPush);
                    break;
                case 2:
                    stackTest.pop();
                    break;
            }
        } while (userInput!=-1);
    }

    public void push(int valueToPush) {
        stack[index++] = valueToPush;
        displayArray();
    }

    public void pop() {
        stack[--index] = 0;
        displayArray();
    }

    public void displayArray() {
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i]+", ");
        }
    }
}
