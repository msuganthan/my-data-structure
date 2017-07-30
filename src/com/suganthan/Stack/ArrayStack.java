package com.suganthan.Stack;

/**
 * Created by msuganthan on 30/7/17.
 */
public class ArrayStack {

    final int MAX_SIZE = 3;
    int top = -1;
    int[] STACK = new int[MAX_SIZE];

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException{
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is "+stack.top()+" !!!");
        //stack.push(4); throws StackOverflowException
        stack.pop();
        stack.pop();
        stack.pop();
        //stack.pop(); throws StackUnderflowException

        System.out.println("Stack is empty "+stack.isEmpty());



    }

    void push(int data) throws StackOverflowException {
        if (top >= MAX_SIZE) {
            throw new StackOverflowException("Stack is full");
        }

        STACK[++top] = data;
    }

    void pop() throws StackUnderflowException{
        if (top < 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        --top;
    }

    int top() throws StackUnderflowException{
        if (top < 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        return STACK[top];
    }

    boolean isEmpty() {
        return top < 0 ? true : false;
    }

}

class StackOverflowException extends Exception {
    StackOverflowException(String message) {
        super(message);
    }
}

class StackUnderflowException extends Exception {
    StackUnderflowException(String message) {
        super(message);
    }
}