package Arrays;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};

        System.out.println("Array: ");
        printArray(arr);
        System.out.println("Max. Profit: " + stockBuyAndSell(arr));
    }

    /*

    Given an array prices[] of size n denoting the cost of stock on each day,
    the task is to find the maximum total profit if we can buy and sell the stocks any number of times.
    Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks
    on any day.
    Examples:
    Input: prices[] = {100, 180, 260, 310, 40, 535, 695}
    Output: 865
    Explanation: Buy the stock on day 0 and sell it on day 3 => 310 - 100 = 210
                       Buy the stock on day 4 and sell it on day 6 => 695 - 40 = 655
                       Maximum Profit  = 210 + 655 = 865

    https://www.geeksforgeeks.org/stock-buy-sell/

    */

    public static int stockBuyAndSell(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int buy = arr[0], sell = 0, profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                buy = arr[i - 1];
                sell = arr[i];
                profit = profit + sell - buy;
            }
        }
        return profit;
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
