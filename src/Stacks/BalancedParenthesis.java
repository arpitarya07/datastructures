package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    Given an expression string exp,
    write a program to examine whether
    the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
    Example:
    Input: exp = “[()]{}{[()()]()}”
    Output: Balanced
    Input: exp = “[(])”
    Output: Not Balanced
 */
public class BalancedParenthesis {
    Map<Character, Character> parenthesisMap;

    public BalancedParenthesis() {
        parenthesisMap = new HashMap<>();
        parenthesisMap.put(']', '[');
        parenthesisMap.put('}', '{');
        parenthesisMap.put(')', '(');
    }

    public static void main(String[] args) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
        System.out.println(balancedParenthesis.isBalancedParenthesis("[()]{}{[()()]()}"));
    }

    public boolean isBalancedParenthesis(String input) {
        char[] inputArr = input.toCharArray();
        Stack<Character> parenthesisStack = new Stack<>();
        for (Character ch : inputArr) {
            if (parenthesisMap.containsKey(ch)) {
                if (parenthesisStack.peek() == parenthesisMap.get(ch)) {
                    parenthesisStack.pop();
                } else {
                    return false;
                }
            } else {
                parenthesisStack.push(ch);
            }
        }
        return parenthesisStack.isEmpty();
    }
}
