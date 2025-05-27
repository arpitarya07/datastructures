package Recursion;

public class BasicRecursionProblems {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci series of a a given no = " + n + " is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + "\t");
        }
        String input = "abccba";
        System.out.println(isPalindrome("abccba", 0, input.length() - 1));
        System.out.println(fact(5));
        System.out.println(sumOfDigits(545));
    }

    /*
    The Fibonacci series is a series where the next term is the sum of the previous two terms.
    The first two terms of the Fibonacci sequence are 0 followed by 1.
    The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
     */
    private static int fib(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return fib(i - 2) + fib(i - 1);
    }

    /* Palindrome
     Given a string, write a Java function to check if it is palindrome or not.
     A string is said to be palindrome if reverse of the string is same as string.
     For example, “abba” is palindrome, but “abbc” is not palindrome
     */
    private static boolean isPalindrome(String input, int i, int j) {
        if (i >= j) {
            return true;
        }
        return (input.charAt(i) == input.charAt(j) && isPalindrome(input, ++i, --j));
    }

    /*
    Factorial of n is the product of all positive descending integers. Factorial of n is denoted by n!.
    For example:
    4! = 4*3*2*1 = 24
     */
    private static int fact(int input) {
        if (input == 0) {
            return 1;
        }
        return input * fact(input - 1);
    }

    /*
    Given a number, we need to find sum of its digits using recursion.
    Examples:
    Input : 12345
    Output : 15
     */
    private static int sumOfDigits(int input) {
        if (input < 10) {
            return input;
        }
        return (input % 10) + sumOfDigits(input / 10);
    }


    public static void printArray(int[] arr) {
        int i = 0;
        while (i <= arr.length - 1) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
    }

}
