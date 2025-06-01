package Arrays;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};

        System.out.println("Array: ");
        printArray(arr);
        System.out.println(maxSumSubArrayOfSizeK_BasicSoln(arr, 2));
        System.out.println(maxSumSubArrayOfSizeK_EffSoln(arr, 2));
    }

    /*

    Max Sum Subarray of Size K
    Given an array of integers and a number k, find the maximum sum of a subarray of size k.

    https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/

    Input  : arr[] = {100, 200, 300, 400},  k = 2
    Output : 700

    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
    Output : 39


    An Efficient Solution is based on the fact that sum of a subarray (or window) of size k
    can be obtained in O(1) time using the sum of the previous subarray (or window) of size k.
    Except for the first subarray of size k, for other subarrays,
    we compute the sum by removing the first element of the last window and
    adding the last element of the current window.


    */
    //A Simple Solution is to generate all subarrays of size k,
    // compute their sums and finally return the maximum of all sums.
    // The time complexity of this solution is O(n*k).

    // Basic Solution: O(n*k)
    public static int maxSumSubArrayOfSizeK_BasicSoln(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }

        int globalSum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int currSum = 0;
            for (int j = i; j < i + k; j++) {
                currSum = currSum + arr[j];
            }
            if (currSum > globalSum) {
                globalSum = currSum;
            }
        }
        return globalSum;
    }


    //An Efficient Solution is based on the fact that sum of a subarray (or window) of size k
    // can be obtained in O(1) time using the sum of the previous subarray (or window) of size k.
    // Except for the first subarray of size k, for other subarrays,
    // we compute the sum by removing the first element of the last window and adding the
    // last element of the current window.

    //Efficient Solution: O(n)
    public static int maxSumSubArrayOfSizeK_EffSoln(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        int globalSum = 0;
        for (int i=0; i<k; i++) {
            globalSum = globalSum + arr[i];
        }
        int currSum = globalSum;
        for (int i=k; i<arr.length; i++) {
            currSum = currSum + arr[i] - arr[i-k];
            if(currSum>globalSum) {
                globalSum = currSum;
            }
        }
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
