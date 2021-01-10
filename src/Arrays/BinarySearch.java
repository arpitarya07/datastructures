package Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,3,6,9,12,45,67,89,99,100};
        System.out.println("Array: "); printArray(arr);
        //int searchElementIndex = binarySearch(arr, 99);
        int searchElementIndexByRecursion = binarySearchByRecursion(arr, 99, 0, arr.length-1);
        //System.out.println("Search Element Index: " + searchElementIndex);
        System.out.println("Search Element Index: " + searchElementIndexByRecursion);
    }

    public static int binarySearch(int[] arr, int searchElement) {
        int start = 0, end = arr.length-1, mid=-1;
        while(start<=end) {
            mid = (start+end)/2;
            if(searchElement==arr[mid]) {
                return mid;
            }
            else if (searchElement < arr[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchByRecursion(int[] arr, int searchElement, int start, int end) {
        int mid = (start+end)/2;
        if(start>end) {
            return -1;
        }
        if(searchElement==arr[mid]) {
            return mid;
        }
        else if (searchElement < arr[mid]){
            return binarySearchByRecursion(arr, searchElement, start, mid-1);
        }
        else {
            return binarySearchByRecursion(arr, searchElement, mid+1, end);
        }
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
