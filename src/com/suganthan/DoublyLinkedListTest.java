package com.suganthan;

import java.util.Scanner;

/**
 * Created by msuganthan on 2/7/17.
 */
public class DoublyLinkedListTest {

    DoublyNode head = null;
    DoublyNode last = null;
    DoublyNode next = null;
    DoublyNode prev = null;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        DoublyLinkedListTest doublyLinkedListTest = new DoublyLinkedListTest();
        int userInput = 0;
        do {
            System.out.println("\nEnter the option");
            System.out.println("1. Add");
            System.out.println("2. Insert in a position");
            System.out.println("3. Remove");

            userInput = doublyLinkedListTest.in.nextInt();
            switch (userInput) {
                case 1:
                    doublyLinkedListTest.add();
                    break;
                case 2:
                    doublyLinkedListTest.insert();
                    break;
                case 3:
                    doublyLinkedListTest.remove();
                    break;
            }
        } while(userInput != -1);
    }

    public void add() {
        System.out.println("Enter the value to insert: ");
        int valueToInsert = in.nextInt();
        if(head == null && last == null) {
            DoublyNode newNode = new DoublyNode(null, valueToInsert, null);
            head = newNode;
            last = newNode;
        } else {
            DoublyNode temp = head;
            while(temp != null) {
                if(temp.next == null) {
                    DoublyNode newNode = new DoublyNode(null, valueToInsert, null);
                    temp.next = newNode;
                    last = newNode;
                    last.previous = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        forwardTranversal();
        backwardTranversal();
    }

    public void insert() {
        System.out.println("Enter the value to insert: ");
        int valueToInsert = in.nextInt();
        System.out.println("Enter  the position: ");
        int positionToInsert = in.nextInt();
        if(head == null && last == null) {
            DoublyNode newNode = new DoublyNode(null, valueToInsert, null);
            head = newNode;
            last = newNode;
        } else {
            DoublyNode temp = head;
            int count = 0;
            while(temp != null) {
                count++;
                if(temp.next == null) {
                    DoublyNode newNode = new DoublyNode(null, valueToInsert, null);
                    temp.next = newNode;
                    last = newNode;
                    last.previous = temp;
                    break;
                } else if(count == positionToInsert) {
                    DoublyNode newNode = new DoublyNode(temp, valueToInsert, temp.next);
                    temp.next.previous = newNode;
                    temp.next = newNode;
                    break;
                }

                temp = temp.next;
            }
        }
        forwardTranversal();
        backwardTranversal();
    }

    public void remove() {
        System.out.println("Enter the element to remove");
        int valueToRemoval = in.nextInt();
        DoublyNode temp = head;
        while(temp!= null) {
            if(temp.getData() == valueToRemoval && temp.next == null && temp.previous ==null) { //first element
                head = null;
                last = null;
                break;
            } else if(temp.getData() == valueToRemoval && temp.next == null && temp.previous !=null) { //last element
                last = temp.previous;
                temp.previous.next = null;
                break;
            } else if (temp.getData() == valueToRemoval) {
                temp.next.previous = temp.previous;
                temp.previous.next = temp.next;
            }

            temp = temp.next;
        }
        forwardTranversal();
        backwardTranversal();
    }

    public void forwardTranversal() {
        System.out.println("Forward Traversal: ");
        DoublyNode temp = head;
        while(temp!=null) {
            System.out.print(" ==> "+temp.getData());
            temp =  temp.next;
        }
    }

    public void backwardTranversal() {
        System.out.println("\nBack ward tranversal: ");
        DoublyNode temp = last;
        while(temp!=null) {
            System.out.print(" ==> "+temp.getData());
            temp =  temp.previous;
        }
    }
}

class DoublyNode {
    DoublyNode previous;
    int data;
    DoublyNode next;

    public DoublyNode(DoublyNode previous, int data, DoublyNode next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public DoublyNode getPrevious() {
        return previous;
    }
}
