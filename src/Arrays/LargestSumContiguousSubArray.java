package Arrays;

public class LargestSumContiguousSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("Array: ");
        printArray(arr);
        System.out.println("Sum: " + largestSumContiguousSubArray(arr));
    }

    /*

    Max or largest sum subarray Sum
    Given an array arr[], the task is to find the elements of a contiguous subarray of numbers
    that has the largest sum.

    Input: arr = [-2, -3, 4, -1, -2, 1, 5, -3]
    Output: [4, -1, -2, 1, 5]
    Explanation:
    In the above input the maximum contiguous subarray sum is 7
    and the elements of the subarray are [4, -1, -2, 1, 5]

    Note: Size of subarray is not fixed

    https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

    */

    public static int largestSumContiguousSubArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int currSum = 0, globalSum = 0, indexStart = 0, indexEnd = 0;
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (currSum >= 0) {
                currSum = currSum + arr[j];
            } else if (currSum < 0) {
                i = j;
                currSum = arr[j];
            }
            if (currSum > globalSum) {
                indexStart = i;
                indexEnd = j;
            }
            globalSum = Math.max(globalSum, currSum);
        }

        System.out.println("Indexes: " + indexStart + " and " + indexEnd);
        return globalSum;
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
