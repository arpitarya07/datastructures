package Arrays;

import java.util.HashMap;

public class PrefixSumProblems {

    public static void main(String[] args) {
//        int[] arr = {1, 4, 45, 6, 8, -64};
        int[] arr = {0, 0, 0, 0, 0, 0};
        System.out.println("Array: ");
        printArray(arr);
//        prefixSum(arr);
//        subArrayWithSumZero(arr);
        rangeAddOperation(arr, 0, 2, 100);
    }

    /*
    Find if there is a subarray with 0 sum
    Input: {4, 2, -3, 1, 6}
    Output: true
    There is a subarray with zero sum from index 1 to 3.
    Soln:
    1. Calculate Prefix Sum array
    2. Insert into hashmap (prefix_sum, first_index_array)
    3. If current prefix_sum is found in hashmap, the indexes where the value
    of sum of array is 0 is {hashmap_index + 1, curr_element_index}
     */
    public static void subArrayWithSumZero(int[] arr) {
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixSumHashMap = new HashMap<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == 0) {
                System.out.println("Index of subarray are: " + i + ", " + i);
                break;
            }
            prefixSum = prefixSum + arr[i];
            if (prefixSum == 0) {
                System.out.println("Sum of elements of entire array until " + i +"th index is 0");
            }
            if (prefixSumHashMap.containsKey(prefixSum)) {
                System.out.println("Indices of subarray are: " + (prefixSumHashMap.get(prefixSum) + 1) + ", " + i);
                break;
            }
            prefixSumHashMap.put(prefixSum, i);
        }


//        for(int i=0; i<=prefixSumArr.length-1; i++) {
//            if (prefixSumHashMap.containsKey(prefixSumArr[i])) {
//                System.out.println("Index of subarray are: "+(prefixSumHashMap.get(prefixSumArr[i])+1)+", "+i);
//                break;
//            }
//                prefixSumHashMap.put(prefixSumArr[i], i);
//        }
    }


    /*
    Constant time range add operation on an array
    Given an array of size N which is initialized with all zeros. We are given many range add queries, which should be applied to this array. We need to print final updated array as our result.

    Examples:
    N = 6
    Arr = [0, 0, 0, 0, 0, 0]
    rangeUpdate1 [0, 2], add 100
    Arr = [100, 100, 100, 0, 0, 0]
    rangeUpdate1 [1, 5], add 100
    Arr = [100, 200, 200, 100, 100, 100]
    rangeUpdate1 [2, 3], add 100
    Arr = [100, 200, 300, 200, 100, 100]
    Which is the final updated array.

    Solution:
    example[0,2] -> add 100
    So, add arr[0] = arr[0]+100, arr[2+1] = -100 and then do prefix sum
     */
    public static void rangeAddOperation(int[] arr, int l, int r, int value) {
        arr[l] = arr[l] + value;
        arr[r + 1] = arr[r + 1] - value;
        printArray(arr);
        int[] rangeAddArr = prefixSum(arr);
        printArray(rangeAddArr);
    }

    private static int[] prefixSum(int[] arr) {
        int[] prefixSumArr = new int[arr.length];
        prefixSumArr[0] = arr[0];
        for (int i = 1; i <= arr.length - 1; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
        }
        return prefixSumArr;
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
