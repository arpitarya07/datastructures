package Arrays;



public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println("Array: ");
        printArray(arr);
        trappingRainWater(arr);
    }

    private static void trappingRainWater(int[] arr) {
        // Find the left and right max for an index and store in left and right array
        int n = arr.length, res = 0;
        int[] lArr = new int[arr.length], rArr = new int[arr.length];
        lArr[0] = arr[0];
        rArr[n-1] = arr[n-1];
        for(int i = 1, j = n-2; i<=n-1; i++,j--) {
            lArr[i] = Math.max(arr[i],lArr[i-1]);
            rArr[j] = Math.max(arr[j],rArr[j+1]);
        }
        for(int i=0; i<n-1; i++) {
            res = res + Math.min(lArr[i],rArr[i]) - arr[i];
        }
        System.out.println("Trapped water = "+res);
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
