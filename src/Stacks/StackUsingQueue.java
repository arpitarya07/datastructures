package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    int size;
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        System.out.println(stack.peek());
    }

    StackUsingQueue() {
        size = 0;
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        queue1.add(value);
        size++;
    }

    public void pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.remove());
        }
        queue1.remove();
        size--;
        queue1 = queue2;
        queue2 = new LinkedList<>();
    }

    public int peek() {
        if (queue1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.remove());
        }
        int peekValue = queue1.peek();
        queue2.add(queue1.remove());
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return peekValue;
    }

}
