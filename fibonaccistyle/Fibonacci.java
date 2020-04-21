package dynamicprogramming.fibonaccistyle;

import java.util.Arrays;

public class Fibonacci {

    static int findFibonacciRecursiveHelper(int n) {
        if(n <= 0)
            return -1;
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);
        return findFibonacciRecursive(dp, n);
    }

    /**
     * Top down approach
     * @param dp
     * @param n
     * @return
     */
    static int findFibonacciRecursive(int[] dp, int n) {
        if(n < 2)
            return n;
        if(dp[n-1] != -1)
            return dp[n-1];
        dp[n-1] = findFibonacciRecursive(dp, n-1) + findFibonacciRecursive(dp, n-2);
        return dp[n-1];
    }

    /**
     * Bottom up approach
     * @param n
     * @return
     */
    static int findFibonacciBottomUp(int n) {
        if(n <= 0)
            return -1;
        if( n <=2 )
            return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String a[]) {
        System.out.println(findFibonacciRecursiveHelper(3));
        System.out.println(findFibonacciRecursiveHelper(4));
        System.out.println(findFibonacciRecursiveHelper(5));
        System.out.println(findFibonacciBottomUp(5));
    }
}
