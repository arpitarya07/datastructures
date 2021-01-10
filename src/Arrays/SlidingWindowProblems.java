package Arrays;

public class SlidingWindowProblems {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 8, 19};
//        int[] arr = {1, 4, 20, 3, 10, 5};
        System.out.println("Array: ");
        printArray(arr);
        subArrayWithReqdSum(arr);
    }
    /*
    Find subarray with given sum | Set 1 (Nonnegative Numbers)
    Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.

    Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Ouptut: Sum found between indexes 2 and 4
    Sum of elements between indices
    2 and 4 is 20 + 3 + 10 = 33

    Soln: Sliding Window Approach
    1. Traverse the array from start to end using l and r indexes.
    2. Update the variable sum by adding element on r, r++, sum = sum + array[r]
    3. If the sum is greater than the given sum, update the variable sum as sum = sum – array[l], l and update l as, l++.
    4. If the sum is equal to given sum, print the subarray and break the loop.
     */
    public static void subArrayWithReqdSum(int[] arr) {
        int l=0, r=0, sum=arr[0], reqdSum=33;
        while(l<arr.length && r<arr.length) {
            if(sum==reqdSum) {
                System.out.println("Indices of subarray are: "+l+" and "+r);
                break;
            }
            else if (sum<reqdSum) {
                r++;
                sum=sum+arr[r];
            }
            else {
                sum=sum-arr[l];
                l++;
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
