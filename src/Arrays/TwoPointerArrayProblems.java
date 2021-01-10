package Arrays;

import java.util.Arrays;

public class TwoPointerArrayProblems {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};

        System.out.println("Array: ");
        printArray(arr);
        pairForSumInArray(arr, 16);
    }

    /*
        Given an array A[] and a number x, check for pair in A[] with sum as x
        Input: arr[] = {0, -1, 2, -3, 1}
        sum = -2
        Output: -3, 1

        Soln:
            Sort the array in non-decreasing order.
            Initialize two index variables to find the candidate
            elements in the sorted array.
            Initialize first to the leftmost index: l = 0
            Initialize second the rightmost index: r = ar_size-1
            Loop while l < r.
            If (A[l] + A[r] == sum) then return 1
            Else if( A[l] + A[r] < sum ) then l++
            Else r–
     */

    private static void pairForSumInArray(int[] arr, int sum) {
        Arrays.sort(arr);
        int beg = 0, end = arr.length - 1;
        while (beg < end) {
            if (arr[beg] + arr[end] == sum) {
                System.out.println("Elements with required sum are: " + arr[beg] + ", " + arr[end]);
                break;
            } else if (arr[beg] + arr[end] > sum) {
                end--;
            } else {
                beg++;
            }
        }
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
