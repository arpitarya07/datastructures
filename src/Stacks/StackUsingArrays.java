package Stacks;

/*
Mainly the following three basic operations are performed in the stack:
Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.
 */

public class StackUsingArrays {

    int[] arr;
    int top;

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays();
        System.out.println(stack.isEmpty());
        // stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        System.out.println(stack.peek());
    }

    StackUsingArrays() {
        top = -1;
        arr = new int[10];
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public void push(int value) {
        if (top == arr.length-1) {
            System.out.println("Stack is full");
            return;
        }
        arr[top+1] = value;
        top++;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        arr[top] = 0;
        top--;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }

}
