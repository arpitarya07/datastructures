package Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        System.out.println("Before reversal: "); printArray(arr);
        int[] arr_reverse = reverseAnArray(arr);
        System.out.println("After reversal: "); printArray(arr_reverse);
    }

    public static int[] reverseAnArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            swap(arr, start, end);
            start++; end--;
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
        while (i <= arr.length-1) {
            System.out.print(arr[i]+" ");
            i++;
        }
        System.out.println();
    }
}

/*
   I/N:    {1, 4, 5, 2}
   O/P:    {2, 5, 4, 1}
 */

