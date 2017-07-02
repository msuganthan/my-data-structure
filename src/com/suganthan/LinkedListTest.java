package com.suganthan;

import java.util.Scanner;

/**
 * Created by msuganthan on 2/7/17.
 */
public class LinkedListTest {
    Node head = null;
    Node last = null;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        int userInput = 0;
        do {
            System.out.println("\nEnter the option");
            System.out.println("1. Insert");
            System.out.println("2. Add at the end");
            System.out.println("3. Delete from the end");
            System.out.println("4. Remove particular element");

            userInput = linkedListTest.in.nextInt();
            switch (userInput) {
                case 1:
                    linkedListTest.insert();
                    break;
                /*case 2:
                    listUsingArrays.add();
                    break;
                case 3:
                    listUsingArrays.delete();
                    break;
                case 4:
                    listUsingArrays.remove();
                    break;*/
            }
        } while(userInput != -1);
    }

    public void insert() {
        System.out.println("Enter the value to insert");
        int valueToInsert = in.nextInt();
        Node newNode = new Node(valueToInsert, null);
        if(head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while(lastNode.next!=null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        display();
    }

    public void display() {
        for(Node temp = head; temp != null; temp = temp.next) {
            System.out.print(" ==> "+ temp.data);
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
