package Stacks;

import java.util.Stack;

public class SmallestElemOnLeft {

    public static void main(String[] args) {
        int[] inputArr = {5, 2, 6, 4, 7};
        smallestElemToLeft(inputArr);
    }

    public static void smallestElemToLeft(int[] arr) {
        Stack<Integer> elemStack = new Stack<>();
        elemStack.push(arr[0]);
        System.out.println("-1");

        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];

            while (!elemStack.isEmpty()) {
                int elemAtTop = elemStack.peek();
                if (elemAtTop > currElem) {
                    elemStack.pop();
                } else {
                    System.out.println(elemAtTop);
                    break;
                }

                if (elemStack.isEmpty()) {
                    System.out.println("-1");
                    break;
                }
            }
            elemStack.push(currElem);
        }
    }

}
