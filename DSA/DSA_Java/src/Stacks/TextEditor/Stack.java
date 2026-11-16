package Stacks.TextEditor;

public class Stack{
    private String[] arr = new String[100];
    private int top = -1;

    boolean isEmpty(){return top == -1;}

    String peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        return arr[top];
    }

    void push(String value) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        arr[top] = value;
    }

    String pop(){
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }

        String result = arr[top];
        arr[top] = null;
        top--;

        return result;
    }

    void clear() {
        while (top != -1) {
            arr[top] = null;
            top--;
        }
    }
}
