package Strings;

import java.util.HashMap;
import java.util.Map;

public class BasicStringProblems {

/*
Given a string, write a Java function to check if it is palindrome or not.
A string is said to be palindrome if reverse of the string is same as string.
For example, “abba” is palindrome, but “abbc” is not palindrome.
 */

    public static void main(String[] args) {
        String input1 = "abcdcba", input2 = "dcba";
        String anagramInput1 = "listen", anagramInput2 = "silent";
        System.out.println(input1 + " is palindrome? " + isPalindrome(input1));
        System.out.println(anagramInput1 + " , " + anagramInput2 + " is anagram? " + isAnagram(anagramInput1, anagramInput2));
        System.out.println("Min no. of characters to be added to both the strings to make it an anagram " + minNoOfCharToMakeAnagram(anagramInput1, anagramInput2));
        System.out.println(input2 + " is subsequence? " + isSubsequence(input1, input2));
    }

    private static boolean isPalindrome(String input1) {
        for (int i = 0, j = input1.length() - 1; i <= j; i++, j--) {
            if (input1.charAt(i) != input1.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /* Anagram
Given 2 strings, check if they are anagram of each other.
Two strings are anagram of each other, if both have same frequency for each character.
Example: abc and bca
*/

    private static boolean isAnagram(String anagramInput1, String anagramInput2) {
        if (anagramInput1.length() != anagramInput2.length()) {
            return false;
        }
        Map<Character, Integer> anagramMap = new HashMap();
        //int count=1;
        for (int i = 0; i <= anagramInput1.length() - 1; i++) {
            if (anagramMap.containsKey(anagramInput1.charAt(i))) {
                Integer count = anagramMap.get(anagramInput1.charAt(i));
                anagramMap.put(anagramInput1.charAt(i), count++);
            } else {
                anagramMap.put(anagramInput1.charAt(i), 1);
            }
        }
        for (int i = 0; i <= anagramInput2.length() - 1; i++) {
            if (anagramMap.containsKey(anagramInput2.charAt(i))) {
                Integer count = anagramMap.get(anagramInput2.charAt(i));
                if (count == 1) {
                    anagramMap.remove(anagramInput2.charAt(i));
                } else {
                    anagramMap.put(anagramInput1.charAt(i), count--);
                }
            } else {
                return false;
            }
        }
        return anagramMap.isEmpty();
    }

    /*
    Given 2 strings, find the minimum number of characters you need
    to add to make both strings anagram of each other.
     */
    private static int minNoOfCharToMakeAnagram(String anagramInput1, String anagramInput2) {

        Map<Character, Integer> anagramMap = new HashMap();
        //int count=1;
        for (int i = 0; i <= anagramInput1.length() - 1; i++) {
            if (anagramMap.containsKey(anagramInput1.charAt(i))) {
                Integer count = anagramMap.get(anagramInput1.charAt(i));
                anagramMap.put(anagramInput1.charAt(i), count++);
            } else {
                anagramMap.put(anagramInput1.charAt(i), 1);
            }
        }
        int countInput2 = 0;
        for (int i = 0; i <= anagramInput2.length() - 1; i++) {
            if (anagramMap.containsKey(anagramInput2.charAt(i))) {
                Integer count = anagramMap.get(anagramInput2.charAt(i));
                if (count == 1) {
                    anagramMap.remove(anagramInput2.charAt(i));
                } else {
                    anagramMap.put(anagramInput2.charAt(i), count--);
                }
            } else {
                countInput2++;
            }
        }
        return anagramMap.size() + countInput2;
    }

    /*
    Given 2 strings, check if the second string is a subsequence of the first string.

   if s2 is a subsequence of a string s1, then s2 can be formed by deleting some characters from s1.
Note: Order should be maintained
    */

    private static boolean isSubsequence(String input1, String input2) {
        for (int i = 0, j = 0; i <= input1.length() - 1; ) {
            if (input1.charAt(i) == input2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (j == input2.length()) {
                return true;
            }
        }
        return false;
    }
}
