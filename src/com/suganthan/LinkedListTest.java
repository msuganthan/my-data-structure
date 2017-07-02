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
            System.out.println("1. Add");
            System.out.println("2. Insert in a position");
            System.out.println("3. Remove");

            userInput = linkedListTest.in.nextInt();
            switch (userInput) {
                case 1:
                    linkedListTest.add();
                    break;
                case 2:
                    linkedListTest.insert();
                    break;
                case 3:
                    linkedListTest.remove();
                    break;
            }
        } while(userInput != -1);
    }

    public void add() {
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

    public void insert() {
        System.out.println("Enter the value to insert");
        int valueToInsert = in.nextInt();
        System.out.println("Enter the position to insert");
        int position = in.nextInt();
        if(head == null) {
            Node newNode = new Node(valueToInsert, null);
            head = newNode;
        } else {
            Node lastNode = head;
            int count = 0;
            while(lastNode != null ) {
                count++;
                if (lastNode.next == null && count == position) { //last node
                    Node newNode = new Node(valueToInsert, null);
                    lastNode.next = newNode;
                } else if(lastNode.next != null && count == position) {
                    Node newNode = new Node(valueToInsert, lastNode.next);
                    lastNode.next = newNode;
                }
                lastNode = lastNode.next;
            }
        }
        display();
    }

    public void remove() {
        System.out.println("Enter the element to remove");
        int valueToRemove = in.nextInt();
        if(head.data ==valueToRemove) {
            head = head.next;
        } else {
            Node temp = head;
            while(temp != null) {
                if(temp.getNext().getData() == valueToRemove && temp.getNext().getNext()==null) {
                    temp.next = null;
                    break;
                } else if (temp.getNext().getData() == valueToRemove) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
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
