package Arrays;

public class BasicArrayProblems {
    /*
    Given 2 arrays, both arrays have same elements,
    but second array has 1 element missing (which was present in the first array)
    Find that missing element.
    [2, 3, 4, 5]    14
    [5, 3, 2]       10
    O/P:  4
    sum(array1) - sum(array2)
    xor(all elements)   =>  4
     */

    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] arr2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2 };
        System.out.println("Array: ");
        printArray(arr1); printArray(arr2);
        System.out.println("Missing element : " + missingElement(arr1, arr2));
    }

    private static int missingElement(int[] arr1, int[] arr2) {
        int sum1=0, sum2=0, missingElement;
        for (int i=0; i<=arr1.length-1; i++) {
            sum1 = sum1+arr1[i];
        }
        for (int i=0; i<=arr2.length-1; i++) {
            sum2 = sum2+arr2[i];
        }
        missingElement=sum1-sum2;
        return missingElement;
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
