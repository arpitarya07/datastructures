package Arrays;


import java.util.HashSet;

public class HashingArrayProblems {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        System.out.println("Array: ");
        printArray(arr);
        pairForSumInArray(arr, 16);
    }

    private static void pairForSumInArray(int[] arr, int sum) {
        HashSet<Integer> arraySet = new HashSet<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arraySet.contains(sum - arr[i])) {
                System.out.println("Elements with required sum are: " + arr[i] + ", " + (sum - arr[i]));
                break;
            }
            arraySet.add(arr[i]);
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
