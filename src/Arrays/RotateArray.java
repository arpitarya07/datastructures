package Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        System.out.println("Before rotation: ");
        printArray(arr1);
        int[] arrRotateShifting = rotateArrayByShifting(arr1, 4);
        int[] arrRotateReversal = rotateArrayByReversal(arr2, 2);
        System.out.println("After rotation by Shifting: ");
        printArray(arrRotateShifting);
        System.out.println("After rotation by Reversal: ");
        printArray(arrRotateReversal);
    }

    public static int[] rotateArrayByShifting(int[] arr, int d) {
        //Save d elements in a new array
        //Shift remaining elements to the left
        //Insert the saved d elements to the right

        int[] storingArr = new int[10];

        for (int i = 0; i < d; i++) {
            storingArr[i] = arr[i];
        }
        for (int i = d; i <= arr.length - 1; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = arr.length - d, j = 0; i <= arr.length - 1; i++, j++) {
            arr[i] = storingArr[j];
        }
        return arr;
    }

    public static int[] rotateArrayByReversal(int[] arr, int d) {
        //Reverse first d elements in the array
        //Reverse remaining elements in the array
        //Reverse the whole array

        reverseAnArray(arr, 0, d - 1);
        reverseAnArray(arr, d, arr.length - 1);
        reverseAnArray(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] reverseAnArray(int[] arr, int start, int end) {
        //int start = 0;
        //int end = arr.length - 1;
        while (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
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

/*
    Rotate the given array by d positions (towards left)
   I/N:    {1, 4, 5, 2, 3, 7},       d = 2
   1st Approach:


           {1, 4}
           {5, 2, 3, 7, 3, 7}
           {5, 2, 3, 7, 1, 4}

           store first d elements in some extra array
           then you can shift remaining elements
           copy back first d elements from the new array to the original array

2nd Approach:

I/N:    {1, 4, 5, 2, 3, 7},       d = 2

           {4, 1, 5, 2, 3, 7}
           {4, 1, 7, 3, 2, 5}
           {5, 2, 3, 7, 1, 4}

           O/P:    {5, 2, 3, 7, 1, 4}

           reverse(0, d-1);
           reverse(d, n-1);
           reverse(0, n-1);


           space complexity:  extra space required


           */
