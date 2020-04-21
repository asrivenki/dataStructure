package dynamicprogramming.boundedknapsackstyle;

public class KnapsackProblem {

    static int maximumProfitRecursionHelper(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[profits.length][capacity+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<=capacity; j++)
                dp[i][j] = -1;
        }
        return maximumProfitRecursion(profits, weights, capacity, 0, dp);
    }

    /**
     * Top down approach
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @param dp
     * @return
     */
    static int maximumProfitRecursion(int[] profits, int[] weights, int capacity, int currentIndex, int[][] dp) {
        if(currentIndex >= profits.length)
            return 0;

        if(capacity <= 0)
            return 0;

        if(dp[currentIndex][capacity] != -1)
            return dp[currentIndex][capacity];

        int profit1 = 0;
        int profit2 = 0;
        if(capacity >= weights[currentIndex]) {
            profit1 = profits[currentIndex] + maximumProfitRecursion(profits, weights, capacity - weights[currentIndex], currentIndex+1, dp);
        }
        profit2 = maximumProfitRecursion(profits, weights, capacity, currentIndex + 1, dp);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }


    /**
     * Bottom up approach
     * @param profits
     * @param weights
     * @param totalCapacity
     * @return
     */
    static int maximumProfitBottomUpHelper(int[] profits, int[] weights, int totalCapacity) {

        //Base check
        if(profits.length != weights.length && totalCapacity <=0 && profits.length == 0)
            return 0;

        // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-capacity] + profits[i])

        int[][] dp = new int[profits.length][totalCapacity+1];
        for(int i=0; i<dp.length; i++) {
            for(int capacity=0; capacity<=totalCapacity; capacity++) {
                if(capacity == 0)
                    dp[i][capacity] = 0;
                else if ( i == 0 ) {
                    if(weights[i] >= capacity)
                        dp[i][capacity] = profits[i];
                    else
                        dp[i][capacity] = 0;
                } else {
                    if( capacity >= weights[i]) {
                        dp[i][capacity] = Math.max(dp[i-1][capacity], dp[i-1][capacity-weights[i]] + profits[i]);
                    } else
                        dp[i][capacity] = dp[i-1][capacity];
                }
            }

        }

        printSelectedItems(dp, profits, weights, totalCapacity);
        return dp[profits.length-1][totalCapacity];
    }

    static void printSelectedItems(int[][] dp, int[] profits, int[] weights, int totalCapacity) {

        System.out.println("Weights selected ");
        int totalProfit = dp[weights.length - 1][totalCapacity];
        for (int i = profits.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][totalCapacity]) {
                System.out.print(i + " ");
                totalCapacity = totalCapacity - weights[i];
                totalProfit = totalProfit - profits[i];
            }
        }

        if(totalProfit != 0)
            System.out.print("0");
        System.out.println();
    }


    public static void main(String ar[]) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;

        System.out.println(maximumProfitRecursionHelper(profits, weights, capacity));
        System.out.println(maximumProfitBottomUpHelper(profits, weights, capacity));
    }
}
