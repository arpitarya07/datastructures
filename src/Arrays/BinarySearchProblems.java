package Arrays;

public class BinarySearchProblems {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 6, 9, 12, 45, 67, 89, 99, 100};
//        System.out.println("Array: ");
//        printArray(arr);
//        int index1 = greatestIndexOfNoJustLessThanOrEqualToX(arr, 99);
//        int index2 = smallestIndexOfNoJustGreaterThanOrEqualToX(arr, 99);
//        noOfTimesXHasCome(arr, index1, index2);
//        System.out.println("Index1: " + index1);
//        System.out.println("Index2: " + index2);
        int mat[][] =
                { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        int rowWithMaxNumberOfOnes = rowWithMaxNumberOfOnes(mat);
        System.out.println(rowWithMaxNumberOfOnes);
//        double sqrt = sqrt(100);
//        double sqrtBinarySearch = sqrtBinarySearch(100);
//        System.out.println("sqrt: " + sqrt);
//        System.out.println("sqrtBinarySearch: " + sqrtBinarySearch);

    }

    /*
    Given a sorted array, and a number x, tell the greatest index of a number less than equal to x.
    I/N:   {1, 3, 5, 7, 9}  , x = 5
    O/P:   2
    I/N:   {1, 3, 5, 7, 9}  , x = 8
    O/P:   3
    I/N:   {1, 3, 5, 7, 7, 9}  , x = 7
    O/P:   4
    Find the index of the number just greater than x, your answer is that index - 1
*/
    public static int greatestIndexOfNoJustLessThanOrEqualToX(int[] arr, int x) {
        int beg = 0, end = arr.length - 1;
        while (beg <= end) {

            int mid = (beg + end) / 2;

            if (arr[mid] <= x) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    /*
        Given a sorted array, and a number x, tell the smallest index of a number greater than equal to x.
    I/N:   {1, 3, 5, 7, 9}  , x = 5
    O/P:   2
    I/N:   {1, 3, 5, 7, 9}  , x = 8
    O/P:   4
    I/N:   {1, 3, 5, 7, 7, 9}  , x = 7
    O/P:   3
    Find the index of the number just smaller than x, your answer is that index + 1
    */
    public static int smallestIndexOfNoJustGreaterThanOrEqualToX(int[] arr, int x) {
        int beg = 0, end = arr.length - 1;
        while (beg <= end) {

            int mid = (beg + end) / 2;

            if (arr[mid] < x) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return beg;
    }

    /*
    Given a sorted array, and a number x, tell the number of times x comes in the array
    I/N:   {1, 3, 5, 7, 9}  , x = 5
    O/P:   1
    I/N:   {1, 3, 5, 7, 9}  , x = 8
    O/P:   0
    I/N:   {1, 3, 5, 7, 7, 9}  , x = 7
    O/P:   2
    last_index - first_index + 1
     */
    public static int noOfTimesXHasCome(int[] arr,int x) {
        int noOfTimesXHasCome = 0;
        int mid = BinarySearch.binarySearch(arr, x);
        if (mid != -1) {
            noOfTimesXHasCome = greatestIndexOfNoJustLessThanOrEqualToX(arr,x) - smallestIndexOfNoJustGreaterThanOrEqualToX(arr,x) + 1;
            System.out.println("noOfTimesXHasCome: " + noOfTimesXHasCome);
        } else {
            System.out.println("x not present");
        }
        return noOfTimesXHasCome;
    }

    public static int rowWithMaxNumberOfOnes(int[][] mat) {
        int maxNoOfOnes = 0, indexWithMaxNoOfOnes = -1;
        for (int i = 0; i <= mat.length-1; i++) {
            int[] arr = mat[i];
            int smallestIndexOf1 = smallestIndexOfNoJustGreaterThanOrEqualToX(arr, 1);
            int totalNoOfOnes = arr.length - smallestIndexOf1;
            if (totalNoOfOnes > maxNoOfOnes) {
                maxNoOfOnes = totalNoOfOnes;
                indexWithMaxNoOfOnes = i;
            }
        }
        return indexWithMaxNoOfOnes;
    }


    /*
       x (real number > 0)

   find the square root of x with precision upto 2 digits after the decimal.

    81 -> 9.00
    2  -> 1.41
    3  -> 1.73

    0 to x+1

    0 0.001, 0.002   1

    for(i=0;i<=x+1;i+=e)
        if(abs(i*i - x) < e)
            return i;

    1.400
    1.401
    1.402
    1.409
    1.410
    1.413
    1.414

    y, z
    y == z
    e = 0.001

    y = 4.5123
    z = 4.5124

    abs(y-z) < e
     */

    public static double sqrt(float x) {
        double e = 0.001;
        if (x == 0) {
            return -1;
        }
        double i=0;
        while (i<=x + 1) {
            if (Math.abs(i * i - x) < e) {
                return i;
            }
            i=i+e;
        }
        return -1;
    }

    public static double sqrtBinarySearch(float x) {
        double e = 0.0001;
        if (x == 0) {
            return -1;
        }
        double beg = 0, end = x+1, mid=0;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (Math.abs(mid*mid - x) < e) {
                return mid;
            } else if (mid*mid < x){
                beg = mid + e;
            } else {
                end = mid-e;
            }
        }
        return mid;
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
