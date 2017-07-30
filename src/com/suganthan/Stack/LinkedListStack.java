package com.suganthan.Stack;

/**
 * Created by msuganthan on 30/7/17.
 */
public class LinkedListStack {

    Node top = null;

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException{
        LinkedListStack listStack = new LinkedListStack();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);

        System.out.println("On the top "+listStack.top());

        listStack.pop();
        listStack.pop();
        System.out.println("On the top "+listStack.top());
    }

    void push(int data) {
        Node node = new Node(data);
        if (top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    void pop() throws StackUnderflowException{
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        top = top.next;
    }

    int top() throws StackUnderflowException{
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return top.data;
    }

    boolean isEmpty() {
        return (top == null);
    }

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}